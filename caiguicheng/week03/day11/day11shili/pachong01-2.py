import requests
from bs4 import BeautifulSoup
import re

def getHttlText(url):
    try:
        r = requests.get(url)
        r.raise_for_status()
        r.encoding = "utf-8"
        return r.text
    except:
        return "error"


def findHtmlText(text):
    soup = BeautifulSoup(text, "html.parser")
    return soup.find_all(string=re.compile(''))


url = "https://www.coolapk.com/apk/"


text = getHttlText(url)
myvalue = findHtmlText(text)
print(myvalue)
