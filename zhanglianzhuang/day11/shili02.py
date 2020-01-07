import requests
from bs4 import BeautifulSoup
import re

allutil=[]


#获取网站全部信息
def getHtml(url):
    try:
        r = requests.get(url, timeout=30)
        r.raise_for_status()
        r.encoding='utf-8'
        return r.text
    except:
        return "error"

def findMyData(text):
    authorlist = []
    soup = BeautifulSoup(text, "html.parser")
    string = soup.select(".card-middle-author > a")
    for au in string:
        authorlist.append(au.get_text().strip())
    print(authorlist)
    return authorlist


def main():
    url = "https://www.taptap.com/top/played"
    text=getHtml(url)
    print(findMyData(text))



if __name__ == '__main__':
    main()