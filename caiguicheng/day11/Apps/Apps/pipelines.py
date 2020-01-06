# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


import pymysql
from twisted.enterprise import adbapi

MYSQL_HOST = 'localhost'
MYSQL_PORT = '3306'
MYSQL_DBNAME = 'fp'
MYSQL_USER = 'root'
MYSQL_PASSWORD = 'admin'
MYSQL_CHARSET = 'utf-8'

class MysqlPipeline(object):
    def __init__(self, dbpool):
        self.dbpool = dbpool

    @classmethod
    def from_settings(cls, settings):  # 函数名固定，会被scrapy调用，直接可用settings的值
        """
        数据库建立连接
        :param settings: 配置参数
        :return: 实例化参数
        """
        adbparams = dict(
            host=settings['MYSQL_HOST'],
            port=settings['MYSQL_PORT'],
            db=settings['MYSQL_DBNAME'],
            user=settings['MYSQL_USER'],
            password=settings['MYSQL_PASSWORD'],
            charset=settings['MYSQL_CHARSET'],
            cursorclass=pymysql.cursors.DictCursor  # 指定cursor类型
        )
        # 连接数据池ConnectionPool，使用pymysql或者Mysqldb连接
        dbpool = adbapi.ConnectionPool('pymysql', **adbparams)
        # 返回实例化参数
        return cls(dbpool)

    def process_item(self, item, spider):
        """
        使用twisted将MySQL插入变成异步执行。通过连接池执行具体的sql操作，返回一个对象
        """
        query = self.dbpool.runInteraction(self.do_insert, item)  # 指定操作方法和操作数据
        # 添加异常处理
        query.addCallback(self.handle_error)  # 处理异常

    def do_insert(self, cursor, item):
        # 对数据库进行插入操作，并不需要commit，twisted会自动commit
        insert_sql = """
        insert into 'apps'('title','volume','downloads','follow','comment','tags','rank_num','rom','developer','rank_num_users','update_time') VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)
                    """
        cursor.execute(insert_sql, (item['title'], item['volume'], item['downloads'], item['follow'],
                                    item['comment'], item['tags'], item['rank_num'], item['rom'],
                                    item['developer'], item['rank_num_users'], item['update_time']))

    def handle_error(self, failure):
        if failure:
            # 打印错误信息
            print(failure)

