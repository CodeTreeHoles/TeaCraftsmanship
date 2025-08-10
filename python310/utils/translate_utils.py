import hashlib
import time
import uuid

import requests

def translateUtils(q):
    url = "https://openapi.youdao.com/api"
    salt=uuid.uuid4()

    # 翻译文本生成sign前进行的处理
    input_text = ""
    if(len(q) == 0):
        return ''
    # 当文本长度小于等于20时，取文本
    if (len(q) <= 20):
        input_text = q
    # 当文本长度大于20时，进行特殊处理
    elif (len(q) > 20):
        input_text = q[:10] + str(len(q)) + q[-10:]


    curtime=int(time.time())

    app_id = "4e49324c396cc7a1"
    app_key= "DWwHykoU7VT0xW08QXB7M801yfDnNAIB"
    sign = hashlib.sha256((app_id + input_text + str(salt) + str(curtime) + app_key).encode('utf-8')).hexdigest()   # sign生成
    data = {
        "q":q,
        "from":"zh-CHS",
        "to":"en",
        "appKey":app_id,
        "salt":salt,
        "sign":sign,
        "signType":"v3",
        "curtime":curtime,
    }

    r = requests.get(url, params = data).json()   # 获取返回的json()内容
    return r["translation"][0]
    # print("翻译后的结果：" + r["translation"][0])   # 获取翻译内容
if __name__ == '__main__':
    print(translateUtils("测试"))