import pymysql


class dbUtil:

    # 初始化
    def __init__(self, host, user, password, database):
        self.host = host
        self.user = user
        self.password = password
        self.database = database

    # 连接数据库
    def connDb(self):
        self.db = pymysql.connect(self.host, self.user, self.password, self.database)

    # 获得游标
    def getCursor(self):
        self.myCursor = self.db.cursor()
        return self.myCursor

    # 关闭数据库
    def closeDb(self):
        self.db.close()

    # 插入数据
    def insertData(self, sql):
        try:
            self.connDb()
            self.getCursor().execute(sql)
            self.db.commit()

        except:
            print("error")
            self.db.rollback()
        self.closeDb()

    # 获得一条数据
    def selectOne(self, sql):
        global result
        try:
            self.connDb()
            n = self.getCursor().execute(sql)
            self.db.commit()
            result = self.getCursor().fetchone()

        except:
            print("error")
            self.db.rollback()
        self.closeDb()
        return result

    # 获得多条
    def selectList(self, sql):
        global result
        try:
            self.connDb()
            n = self.getCursor().execute(sql)
            self.db.commit()
            result = self.getCursor().fetchall()

        except:
            print("error")
            self.db.rollback()
        self.closeDb()
        return result

    # 更新数据
    def updateData(self, sql):
        global n
        try:
            self.connDb()
            n = self.getCursor().execute(sql)
            self.db.commit()

        except:
            print("error")
            self.db.rollback()
        self.closeDb()
        return n

    # 删除数据
    def deleteData(self, sql):
        global n
        try:
            self.connDb()
            n = self.getCursor().execute(sql)
            self.db.commit()

        except:
            print("error")
            self.db.rollback()
        self.closeDb()
        return n

    # 打开数据库连接
    # db = pymysql.connect("localhost", "root", "admin", "fp")
    # # 通过游标创建数据库对象
    # myCursor = db.cursor()

    # 插入数据
    # sql_insert = """
    # insert into admin (id,username,password)
    # value (111,'aaa','sss')
    # """
    #
    # sql_select = """
    # select * from admin
    # """
    #
    # sql_update = """
    # update admin set username = "%s",password = "%s" where id = "%d"
    # """ % ("dddddd", "dddddd", 1)
    #
    # sql_update = """
    # update admin set username = "%s",password = "%s" where id = "%d"
    # """ % ("dddddd", "dddddd", 1)

    # 关闭数据库
    # db.close()
