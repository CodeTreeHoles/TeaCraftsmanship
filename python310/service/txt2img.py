import uuid

import requests
import io
import base64
from PIL import Image, PngImagePlugin
c = -1
def txt2img(new_prompt):
    global c
    # Stable Diffusion部署地址
    url = "http://localhost:7860"
    payload = {
        # 模型设置
        "override_settings": {
            "sd_model_checkpoint": "lattezenLandscape_v10.safetensors",
        },
        "prompt": "{highres},original, {{no human}},{fbest quality}, " + new_prompt ,
        "negative_prompt": "(worst quality:2), (low quality:2), (normal quality:2), lowres, normal quality,NSFW,"
                           "((monochrome)),((grayscale)),bottle, ng_deepnegative_v1_75t,"
                           "{human},man,{girl},",
        "width": 512,
        "height": 512,
        "steps": 10,
        "seed": c,
        "sampler_name": "DPM++ 2M",
    }

    response = requests.post(url=f'{url}/sdapi/v1/txt2img', json=payload)

    r = response.json()
    for i in r['images']:
        image = Image.open(io.BytesIO(base64.b64decode(i.split(",", 1)[0])))

        png_payload = {
            "image": "data:image/png;base64," + i
        }
        response2 = requests.post(url=f'{url}/sdapi/v1/txt2img', json=png_payload)

        PI = PngImagePlugin.PngInfo()
        PI.add_text("parameters", response2.json().get("info"))
        uuid_ = uuid.uuid4()
        image.save(f'python310/images/{uuid_}.png', pnginfo=PI)

        return f'python310/images/{uuid_}.png'
