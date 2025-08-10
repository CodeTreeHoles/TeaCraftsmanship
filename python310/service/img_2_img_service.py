# 图生图-----甘雨
# controlnet------canny depth
# 赛博cos


import requests
import io
import base64
from PIL import Image
import cv2
import numpy as np


def img2img(image_url):
    # Stable Diffusion部署地址
    url = "http://localhost:7860"

    prompt = ("{highres},{{masterpiece}},{fbest quality}, original, reflection, unreal engine, body shadow,"
              "Best quality, masterpiece, ultra high res, (photorealistic:1.4), raw photo,1girl,blue hair, blue eyes,"
              "wide-eyed, <lora:甘雨:1>")
    negative_prompt = ("(worst quality:2), (low quality:2), (normal quality:2), lowres, normal quality,((monochrome)),"
                       "((grayscale)),bottle, ng_deepnegative_v1_75t,NSFW")

    # image_url = "https://hui-tea.oss-cn-hangzhou.aliyuncs.com/R-C.jpg" # 输入图片地址

    image_response = requests.get(image_url)
    image_array = np.frombuffer(image_response.content, dtype=np.uint8)
    img = cv2.imdecode(image_array, cv2.IMREAD_COLOR)  # 此处为读取一张图片作为输入图像

    # 编码图像
    retval, bytes = cv2.imencode('.png', img)
    encoded_image = base64.b64encode(bytes).decode('utf-8')

    payload = {
        # 模型设置
        "override_settings": {
            "sd_model_checkpoint": "onlyrealistic_v30BakedVAE.safetensors",
        },

        # 基本参数
        "prompt": prompt,
        "negative_prompt": negative_prompt,
        "steps": 20,
        "sampler_name": "DPM++ SDE",
        "width": 512,
        "height": 696,
        "batch_size": 1,
        "n_iter": 1,
        "seed": 1,
        "cfg_scale": 6,  # 重绘幅度
        "CLIP_stop_at_last_layers": 2,
        "init_images": [encoded_image],

        # 面部修复 face fix
        "restore_faces": False,
        "alwayson_scripts": {
            "controlnet":
                {
                    "args": [
                        # 姿势检测
                        {
                            "enabled": True,  # 启用
                            "control_mode": 0,  # 对应webui 的 Control Mode 可以直接填字符串 推荐使用下标 0 1 2
                            "model": "control_v11p_sd15_openpose [cab727d4]",  # 对应webui 的 Model
                            "module": "openpose_full",  # 对应webui 的 Preprocessor
                            "weight": 1,  # 对应webui 的Control Weight
                            "resize_mode": "Crop and Resize",
                            "threshold_a": 200,  # 阈值a 部分control module会用上
                            "threshold_b": 245,  # 阈值b
                            "guidance_start": 0,  # 什么时候介入 对应webui 的 Starting Control Step
                            "guidance_end": 0.7,  # 什么时候退出 对应webui 的 Ending Control Step
                            "pixel_perfect": True,  # 像素完美
                            "processor_res": 512,  # 预处理器分辨率
                            "save_detected_map": False,  # 因为使用了 controlnet API会返回生成controlnet的效果图，默认是True，如何不需要，改成False
                            "input_image": "",  # 图片 格式为base64
                        },
                        # 深度估算
                        {
                            "enabled": True,  # 启用
                            "control_mode": 0,  # 对应webui 的 Control Mode 可以直接填字符串 推荐使用下标 0 1 2
                            "model": "control_v11f1p_sd15_depth [cfd03158]",  # 对应webui 的 Model
                            "module": "depth_leres",  # 对应webui 的 Preprocessor
                            "weight": 1,  # 对应webui 的Control Weight
                            "resize_mode": "Crop and Resize",
                            "threshold_a": 200,  # 阈值a 部分control module会用上
                            "threshold_b": 245,  # 阈值b
                            "guidance_start": 0,  # 什么时候介入 对应webui 的 Starting Control Step
                            "guidance_end": 0.7,  # 什么时候退出 对应webui 的 Ending Control Step
                            "pixel_perfect": True,  # 像素完美
                            "processor_res": 512,  # 预处理器分辨率
                            "save_detected_map": False,  # 因为使用了 controlnet API会返回生成controlnet的效果图，默认是True，如何不需要，改成False
                            "input_image": "",  # 图片 格式为base64
                        }
                    ]
                }
        },
        # 高清修复 highres fix
        # "enable_hr": True,
        # "denoising_strength": 0.4,
        # "hr_scale": 2,
        # "hr_upscaler": "Latent",

    }

    response = requests.post(url=f'{url}/sdapi/v1/img2img', json=payload)
    r = response.json()
    image = Image.open(io.BytesIO(base64.b64decode(r['images'][0])))

    new_image = image_url.split('/')[-1]
    image.save(f'images/{new_image}')

    return new_image
