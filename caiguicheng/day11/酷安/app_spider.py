# encoding=utf-8
import requests
import time
import traceback
from multiprocessing import Pool
from lxml import etree
from pymysql import connect
from pymysql import cursors


# 网页获取
def get_html(url):
    time.sleep(2)
    #	请求头设置
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36'
    }
    try:
        resp = requests.get(url, headers=headers)
        if resp.status_code == 200:
            return resp.text
    except Exception:
        print("获取网页失败,", Exception)
        return None


#	获取最后一页
def get_last_page(content):
    if content:
        html = etree.HTML(content)
        href = html.xpath('/html/body/div/div[2]/div[2]/div[3]/div[2]/ul/li[9]/a/@href')
        page = str(href).split("=")[1].split("'")
        return page[0]
    else:
        return None


#	每一页的app信息汇总
def parse_html(detail):
    if detail == None:
        print("不可用--detail")
        return None
    html = etree.HTML(detail)
    root = html.xpath('/html/body/div/div[2]/div[2]/div[3]/a')
    for children in root:
        #	app名字
        name = children.xpath('./div/div/div/p[1]/text()')[0]
        grade_size = children.xpath('./div/div/div/p[2]/text()')
        temp = grade_size[0].split(' ')
        #	app评分
        grade = temp[0][:-1]
        #	下载次数
        downlaod_count = children.xpath('./div/div/div/p[2]/span/text()')[0].split(" ")[0].split("次")[0]
        #	数据清洗‘万’转化为数字
        if '万' in downlaod_count:
            downlaod_count = float(downlaod_count.split('万')[0]) * 10000

        yield {
            'name': name,
            'grade': grade,
            'download_count': downlaod_count,
            'href': children.xpath('./@href')
        }


# 根据app的超链接获取更加具体的信息（获取标签和评分） 详细信息
def get_detail(app_detail):
    html = etree.HTML(app_detail)
    comment = html.xpath('/html/body/div/div[2]/div[2]/div[2]/div/div[4]/div/div[1]/p/text()')
    #	对获取的节点进行判断
    if len(comment) == 0:
        comment = html.xpath('/html/body/div/div[2]/div[2]/div[2]/div/div[5]/div/div[1]/p/text()')
        if len(comment) == 0:
            comment = html.xpath('/html/body/div/div[2]/div[2]/div[2]/div/div[3]/div/div[1]/p/text()')

    #	对获取的节点进行判断
    tags = html.xpath('/html/body/div/div[2]/div[2]/div[2]/div/div[5]/p[2]/a/@href')
    if len(tags) == 0:
        tags = html.xpath('/html/body/div/div[2]/div[2]/div[2]/div/div[6]/p[2]/a/@href')
        if len(tags) == 0:
            tags = html.xpath('/html/body/div/div[2]/div[2]/div[2]/div/div[4]/p[2]/a/@href')


    #	对获取的节点进行判断
    tags = html.xpath('/html/body/div/div[2]/div[2]/div[2]/div/div[6]/p[2]/a/@href')
    if len(tags) == 0:
        tags = html.xpath('/html/body/div/div[2]/div[2]/div[2]/div/div[6]/p[2]/a/@href')
        if len(tags) == 0:
            tags = html.xpath('/html/body/div/div[2]/div[2]/div[2]/div/div[4]/p[2]/a/@href')


    comment_count = comment[0].split('个')[0][1:]
    if '万' in comment_count:
        comment_count = float(comment_count.split('万')[0]) * 10000

    return comment_count, "".join(tag.split('/')[-1] + "/" for tag in tags)


#	MySQL创建数据库和表
def create_database_table():
    data_base = 'app_db'
    base_sql = "create database if not exists " + data_base
    table_sql = '''
					CREATE TABLE IF NOT EXISTS `app_table` (
   					 	`id` INT(11) NOT NULL AUTO_INCREMENT,
    					`name` VARCHAR(100) COLLATE utf8_bin NOT NULL,
   						`grade` DECIMAL(2,1) NOT NULL,
						`grade_count` VARCHAR(50) NOT NULL,
    					`download_count` VARCHAR(50) NOT NULL,
						`tag` VARCHAR(400) COLLATE utf8_bin NOT NULL,
    					`href` VARCHAR(300) COLLATE utf8_bin NOT NULL,
    					PRIMARY KEY (`id`)
					) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin
					AUTO_INCREMENT=1
				'''
    #	连接数据库
    con = connect(host="localhost", user="root", password="admin", charset="utf8mb4")
    try:
        #	创建右边
        cur = con.cursor()
        # 	创建数据库app_db
        cur.execute(base_sql)
        #	选择数据库
        con.select_db(data_base)
        #	创建表
        cur.execute(table_sql)
        #	提交事务
        con.commit()
        print("创建数据库和表成功啦！")
    except Exception:
        print("创建数据库或者表出错啦！", traceback.print_exc())
        #	回滚事务
        con.rollback()
    finally:
        cur.close()
        con.close()


#	MySQL向app_table插入数据
def insert_to_table(msg_dict):
    con = connect(host="localhost", user="root", password="admin", db="app_db", charset="utf8mb4")
    #	python默认插入的字符串类型，字段都是字符串类型
    sql = "insert into `app_table` (`name`,`grade`,`grade_count`,`download_count`,`tag`,`href`) values(%s,%s,%s,%s,%s,%s)"
    try:
        #	创建游标
        cur = con.cursor()
        #	执行sql语句
        cur.execute(sql, (
            msg_dict['name'], msg_dict['grade'], msg_dict['grade_count'], msg_dict['download_count'], msg_dict['tag'],
            msg_dict['href']))
        #	提交事务
        con.commit()
        print('插入成功，%s' % msg_dict['name'])
    except Exception:
        print("插入数据失败,", traceback.print_exc())
    finally:
        cur.close()
        con.close()


def main(offset):
    content = get_html('https://www.coolapk.com/apk?p=' + str(offset))
    details = parse_html(content)
    for detail in details:
        #	`name`,`grade`,`grade_count`,`tag`,`download_count`,`href`
        content = get_html('https://www.coolapk.com' + detail['href'][0])
        grade_tage = get_detail(content)
        app_msg = {
            "name": detail['name'],
            "grade": detail['grade'],
            "grade_count": grade_tage[0],
            "download_count": detail['download_count'],
            "tag": grade_tage[1],
            "href": detail['href'][0]
        }
        #	print(app_msg)
        insert_to_table(app_msg)

    print("完成时间，%s" % time.strftime('%Y-%m-%d-%H-%M-%S', time.localtime(time.time())))


#	多进程
if __name__ == '__main__':
    create_database_table()
    content = get_html("https://www.coolapk.com/apk/")
    last_page = get_last_page(content)
    # 创建线程池
    pool = Pool()
    offset = ([x for x in range(1, int(last_page) + 1)])
    # 第一个参数是函数，第二个参数是一个迭代器，把迭代器的数字作为参数传进去
    pool.map(main, offset)
    # 关闭线程池
    pool.close()
    # 主线程阻塞等待子线程的退出
    pool.join()
