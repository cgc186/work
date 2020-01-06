import requests
from bs4 import BeautifulSoup
import re

allutil = []

def getHtmlText(url):
    try:
        r = requests.get(url)
        r.raise_for_status()
        r.encoding = "utf-8"
        return r.text
    except:
        return "error"

# 获取网页当中的相关数据
def fallMyData(text):
    data = text.find_all('tr')
    for tr in data:
        ltd = tr.find_all('td')
        if len(ltd) == 0:
            continue
        singUniv = []
        for td in ltd:
            singUniv.append(td.string)
        allutil.append(singUniv)


# 规定输出的格式如下
def myListTableth(num):
    print("{:^4} {:^10} {:^5}{:^8} {:^10}".format("排名", "应用", "省市", "总分", "指标"))
    for i in range(num):
        u = allutil[i]
        print(u)


def main():
    url = "https://www.qimai.cn/rank/index/brand/grossing/device/iphone/country/tw/genre/5000"
    html = getHtmlText(url)
    soup = BeautifulSoup(html, "html.parser")
    fallMyData(soup)
    myListTableth(310)

main()