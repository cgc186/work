import pymysql

# 引入模块中的函数或类
from shixi2 import zlzssb

zlz = zlzssb("确实,")
print(zlz)

# 字符串长度
# print(len("sb"))

# num1 = 123.123
#
# print("{:.2f}".format(num1))
#
# num2, num3 = 12, 13
# print(num2)
# print(num3)
#
# array1 = [1, 2, 3, 4]
#
# print(3 in array1)
#
# num4 = 12
# num5 = 23
# num6 = 23
# # 条件判断
# if num4 is num5:
#     print("两个变量标识相同")
# else:
#     print("标识符不相同")
#
# if num6 is num5:
#     print("两个变量标识相同")
# else:
#     print("标识符不相同")
# # 字符串截取
# var1 = "python shixi1"
# print(var1[1:10:2])
#
# # for循环的格式
# for var2 in var1:
#     print(var2)
# print("我们已经跳出for循环的语句块")


# 列表(下标从0开始)
# list1 = ["python1", "python2", "python3", "python4", "python5", "python6", "python7"]
#
# print(list1[1:3])
# 如果列长为负,从列表的值倒过来取值
# print(list1[1:-3])
# 如果提取列表的下标为负数时,则从列表的末尾开始读取
# print(list1[-1])

# 元祖 只有一次性赋值,不能操作此类型,只能进行使用
# myList = (1, "python", True, "hello", 3)
# print(myList)
# list4 = list(myList)
# print(list4)
# var4 = list4.index(3)
# print(var4)
# myList2 = (23, 43, 45)
# myList3 = myList + myList2
# myList4 = tuple(list4)
#
# print(myList4)

#
# # 字典
# iList = {'name': 'zlz', 'age': '11', 'pwd': '123456'}
# print(iList)
# print(iList['name'])
# iList['address'] = 'py'
# print(iList)
#
# myArray = ['apple', 'banana']
# for my in myArray:
#     print(my)
#
# var = 20
# while var > 0:
#     print(var)
#     var = var - 1
#     if var == 15:
#         break
#
# str = 'Python'
# for str1 in str:
#     if str1 == 'h':
#         pass
#         print("这是我的空白行")
#
#     print(str1)


def mydef(num):
    num1 = num + 1
    return num1


var11 = mydef(12)
