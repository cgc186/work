# 规定比赛规则
# 1.每场比赛5局3胜
# 2.每局采用积分制:<前四局采用25分满分,每个队只有赢得至少25分,并且超出对方2分才算获胜>
#                  决胜第五局,采用15分制,先获取15分并且超出对方2分为胜利

from random import random


# 开始设计<1.接送每个队的实力值(范围是0~1),比赛的场次数>
#          2.设定每局比赛的规则方法
#          3.模拟一局比赛
#          4-1.模拟异常比赛,4-2.模拟几场比赛
#          5.公布比赛结果

# 第一步
def getAbility():
    abiA = eval(input("请输入甲队的实力值(0~1)为:"))
    abiB = eval(input("请输入乙队的实力值(0~1)为:"))
    scene = eval(input("请输入需要模拟比赛的场次:"))
    return abiA, abiB, scene


# 第二步
def setRule(sce, sumA, sumB):
    if sce <= 4:
        return (sumA >= 25 and abs(sumA - sumB) > 2) or (sumB >= 25 and abs(sumB - sumA) > 2)
    else:
        return (sumA >= 15 and abs(sumA - sumB) >= 2) or (sumB >= 15 and abs(sumB - sumA) >= 2)


# 第三步
def oneGame(sce, abiA, abib):
    sumA, sumB = 0, 0
    serv = 'A'
    while not setRule(sce, sumA, sumB):
        if serv == 'A':
            if random() > abiA:
                sumB += 1
                serv = 'B'
            else:
                sumA += 1
        if serv == 'B':
            if random() > abib:
                sumA += 1
                serv = 'A'
            else:
                sumB += 1
    print("甲队第{}场获取分数为:{}".format(sce, sumA))
    print("乙队第{}场获取分数为:{}".format(sce, sumB))
    return sumA, sumB


# 第四步-1
def match(abiA, abiB):
    one = 1
    winA, winB = 0, 0
    for _ in range(5):
        sumA, sumB = oneGame(one, abiA, abiB)
        if sumA > sumB:
            winA += 1
        else:
            winB += 1
        one += 1
        if winA == 3 or winB == 3:
            break
    return winA, winB


# 第四步-2
def severalFields(n, abiA, abiB):
    winA, winB = 0, 0
    for _ in range(n):
        winA, winB = match(abiA, abiB)
        if winA > winB:
            winA += 1
        else:
            winB += 1
    return winA, winB


# 第五步
def printResultOfCompetition(field, winA, winB):
    print("比赛结束,共模拟{}场比赛".format(field))
    print("甲队获胜{}场比赛,占比{:0.1%}".format(winA, winA / field))
    print("乙队获胜{}场比赛,占比{:0.1%}".format(winB, winB / field))


# 编排调用顺序
def main():
    abiA, abiB, field = getAbility()
    winA, winB = severalFields(field, abiA, abiB)
    printResultOfCompetition(field, winA, winB)


# 设置启动
main()

