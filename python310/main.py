from flask import Flask, request

from service.img_2_img_service import img2img
from service.txt2img import txt2img
from utils.file_utils import FileUtils
from utils.oss_utils import ossUtils
from flask_cors import CORS

from utils.translate_utils import translateUtils

app = Flask(__name__)
CORS(app)  # 允许所有域的跨域请求

teas = {'太平猴魁','黄山毛峰'}

# 定义一个简单的GET路由
@app.route('/ai', methods=['GET'])
def index():
    return "Hello, this is your backend service!"
# 定义一个POST路由，接收JSON数据
@app.route('/ai/img2img', methods=['POST'])
def process_data():
    data = request.json
    # 在这里处理数据...
    image_url = data['image_url']
    new_image_path = img2img(image_url)
    new_image_path = f'images/{new_image_path}'

    # 上传到oss存储容器中
    oss = ossUtils()
    oss.ossUpload(new_image_path,new_image_path)

    # 删除图生图产生的图片
    file_utils = FileUtils()
    file_utils.remove_file(new_image_path)
    return oss.get_object_url(new_image_path)  # 返回处理后的数据
@app.route('/ai/txt2img', methods=['POST'])
def process_txt():
    # return "0"
    data = request.json
    #获取提示词
    new_prompt = data['prompt']
    #处理提示词
    is_translate = True
    global teas
    for i in teas:
        if i in new_prompt:
            new_prompt = new_prompt.replace(i, '')
            new_prompt = translateUtils(new_prompt) + f", <lora:{i}:1>"
            is_translate = False
    if(is_translate):
        new_prompt = translateUtils(new_prompt)  # 翻译为英文
    print("提示词"+":"+new_prompt)
    img_url = txt2img(new_prompt)

    # 上传到oss存储容器中
    oss = ossUtils()
    oss.ossUpload(img_url,img_url)

    print(oss.get_object_url(img_url))
    # 删除图生图产生的图片
    file_utils = FileUtils()
    file_utils.remove_file(img_url)
    return oss.get_object_url(img_url)  # 返回处理后的数据
if __name__ == '__main__':
    app.run(debug=True)  # 在调试模式下运行Flask应用
