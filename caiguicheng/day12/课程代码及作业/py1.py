# 类的说明<1.类的名称;2.使用:结合缩进来定义类的内容;3.self代表类的实例,而非类>
# class myUser:
#     i = 343
#
#     def myprint(self):
#         return "hello zlz"
#
#
# my = myUser()
#
# print("打印类中的属性", my.i)
# print("对类当中的方法进行调用", my.myprint())
#
#
# class myAdd:
#     def __init__(self, num1, num2):
#         self.r = num1
#         self.x = num2
#
#     def numAdd(self):
#         num = self.x + self.r
#         return num
#
#
# myA = myAdd(3, 4)
#
# print(myA.r, myA.x)
# print(myA.numAdd())


# 类当中的私有属性的应用
class persons:
    name = ""
    # 私有属性
    __weith = 0

    def __init__(self, n, w):
        self.name = n
        self.__weith = w

    def myprint(self):
        print("%s 说: 我的身高为 %d" % (self.name, self.__weith))


#
# p = persons("cai", 500)
# p.myprint()
# print(p.name)
# print(p.__weith)

class student(persons):
    grade = ''

    # 子类继承父类当中的构造方法
    def __init__(self, n, w, g):
        persons.__init__(self, n, w)
        self.grade = w

    def mySPrint(self):
        print("%s 说: 我正在上 %s 年级" %(self.name,self.grade))

    def myprint(self):
        print("%s 说: 我的身高是私有属性" % (self.name))


s = student("cai",17979,"2")
s.mySPrint()
s.myprint()