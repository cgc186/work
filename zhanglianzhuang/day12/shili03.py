# #类的声明(1. 类名称; 2.使用:结合缩进来定义类当中的内容; 3. self代表类的实例，而非类)
# class myUser:
#     i = 251
#     def myprint(self):
#         return 'hello python'
#
# #实例化类
# mm = myUser()
#
# print("打印类当中的属性值", mm.i)
# print("对类中方法调用",mm.myprint())
#
#
# #类的构造方法及公共属性的使用
# class myAdd:
#     def __init__(self,nun1,num2):
#         self.r=nun1
#         self.x=num2
#
#     def numadd(self):
#         num=self.r+self.x
#         return num
# ma=myAdd(3,4)
# print(ma.numadd())
#
#类当中的私有属性的应用
class person:
    # 定义基本属性
    name=''
    #私有属性
    __weith=0
    def __init__(self,n,w):
        self.name=n
        self.__weith=w

    def myprint(self):
        print("%s说：我的身高为%d"%(self.name,self.__weith))
# p = person('zlz',170)
# p.myprint()

class student(person):
    grade=''
    def __init__(self,n,w,g):
        person.__init__(self,n,w)
        self.grade=g
    def stuprint(self):
        print("%s说：我没有身高,年级%d"%(self.name,self.grade))
    def myprint(self):
        print("我的身高为私有信息不允许访问")
s=student('cgc',170,2)
s.myprint()
s.stuprint()