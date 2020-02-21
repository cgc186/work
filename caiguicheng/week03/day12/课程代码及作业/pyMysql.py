import pymysql

# 打开数据库连接
db = pymysql.connect("localhost", "root", "admin", "fp")
# 通过游标创建数据库对象
sursor = db.cursor()

# 查找数据库版本
sursor.execute("select version()")

# 获取当前信息
data = sursor.fetchone()

print("数据库的版本为%s" % data)

# 关闭数据库
db.close()