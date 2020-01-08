#类的说明<1.类的名称;2.使用:结合缩进来定义类的内容;3.self代表类的实例,而非类>
class myUser:
    i =343
    def myprint(self):
        return 'hello'

#实例化类
my = myUser()
print("打印类当中的属性值:",my.i)
print("对类当中的方法进行调用:",my.myprint())


#类的构造方法及公共属性的使用
class myAdd:
    def __init__(self,num1,num2):
        self.r = num1
        self.x = num2
    def numADD(self):
        num = self.x+self.r
        return num
myA = myAdd(3,4)
print(myA.r,myA.x)
print(myA.numADD())


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

p = persons("cai", 500)
p.myprint()
print(p.name)
print(p.__weith)



