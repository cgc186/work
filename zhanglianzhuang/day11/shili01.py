import requests
from bs4 import BeautifulSoup
import re
def getHtml(url):
    try:
        r = requests.get(url, timeout=30)
        r.raise_for_status()
        r.encoding='utf-8'
        return r.text
    except:
        return "error"

def findHtmlText(text):
    soup=BeautifulSoup(text, "html.parser")
    return soup.find_all(string=re.compile("taptap"))


url = "https://www.taptap.com/top/played"

text=getHtml(url)
print(findHtmlText(text))
