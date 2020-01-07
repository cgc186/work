import time
import requests
from bs4 import BeautifulSoup
import pymysql
import json

conn = pymysql.connect(host="localhost", user="root", password="admin", database="fp", charset="utf8")
cursor = conn.cursor()  # 执行完毕返回的结果集默认以元组显示

headers = {
    "user-agent": "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139"
}

def getAjaxtext(url,page):
    data={
        'page': page,
        'totol': 30
    }
    s = requests.session()
    str = json.loads(s.get(url, params=data).text).get('data').get('html')
    fakeHead = """
    <!DOCTYPE html">
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Fake Title</title>
    <body>
    """
    fakeTail = """
    </body>
    </head>
    </html>
    """
    str = fakeHead + str + fakeTail

    #print(str)
    return str

def get_html_text(url):
    response = requests.get(url, headers=headers)
    return response.text


def parpse_htmltext(html, n):
    soup = BeautifulSoup(html, "html.parser")

    ranklist = soup.select(".top-card-order-text")
    namelist = soup.select(".card-middle-title > h4")
    scorelist = soup.select(".middle-footer-rating > span")
    gametypelist = soup.select(".card-middle-category > a")
    gameauthorlist = soup.select(".card-middle-author > a")
    gamedescriptionlist =soup.select(".card-middle-description")
    #print(gametypelist)
    ranks=[]
    names = []
    scores = []
    gametypes = []
    gameauthors = []
    gamedescriptions = []
    for au in ranklist:
        ranks.append(au.get_text().strip())
    for au in namelist:
        names.append(au.get_text().strip().strip('CN').strip())
    for au in scorelist:
        scores.append(au.get_text().strip())
    for au in gametypelist:
        gametypes.append(au.get_text().strip())
    for au in gameauthorlist:
        gameauthors.append(au.get_text().strip().strip('厂商:').strip())
    for au in gamedescriptionlist:
        gamedescriptions.append(au.get_text().strip())
    print(gameauthors)
    flag = 0
    for i in names:
        sql = "insert into game(gname, author, score, description, category, grank)" \
              " VALUES ('%s','%s','%s','%s','%s','%s')"%\
              (i, gameauthors[flag], scores[flag], gamedescriptions[flag], gametypes[flag], n)
        n+=1
        flag+=1
        try:
            # 执行sql语句
            cursor.execute(sql)
            # 提交到数据库执行
            conn.commit()
        except Exception as e:
            print(e)
            # 如果发生错误则回滚
            conn.rollback()

    # 关闭数据库连接



# 主函数
def main():
    #url = "https://www.taptap.com/top/played"
    url = "https://www.taptap.com/ajax/top/played"
    html = get_html_text(url)
    #parpse_htmltext(html, n)
    for i in range(1,13):
        time.sleep(3)
        ajaxhtml=getAjaxtext(url, i)
        n = (i-1)*30+1
        parpse_htmltext(ajaxhtml, n)
    conn.close()


if __name__ == '__main__':
    main()