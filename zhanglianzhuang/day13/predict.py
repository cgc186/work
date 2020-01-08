# 规定比赛规则:
# 1、每场比赛5局3胜
# 2、每局采用积分制: (前四局采用25分，每个队只有赢得至少25分，并且超出对方2分才算获胜)
#   决胜第五局， 采用15分先获取15.并且超出对2分会胜利



from random import random

# 开始设计(1. 接收每个队的实力值(0~1), 比赛场次数)
#         2.设定每局比赛的规则方法
#         3.模拟一局比赛
#         4.模拟一场比赛（-->模拟几场比赛）
#         5.公布比赛结果

# 第一步
def getAbility():
    abilityA = eval(input("请输入甲队能力值(0~1):"))
    abilityB = eval(input("请输入乙队能力值(0~1)"))
    num = eval(input("请输入要进行比赛的场数:"))
    return abilityA, abilityB, num

# 第二步
def setRule(sumA,sumB,num):
    if num<=4:
        return (sumA>=25 and abs(sumA-sumB)>2) or(sumB>=25 and abs(sumA-sumB)>2)
    else:
        return (sumA>=15 and abs(sumA-sumB)>=2) or(sumB>=15 and abs(sumA-sumB)>=2)

# 第三步
def oneGame(num, abilityA, abilityB):
    sumA, sumB = 0, 0
    sery = 'A'
    while not setRule(num,sumA,sumB):
        if sery=='A':
            if random()>abilityA:
                sumB += 1
                sery ='B'
            else:
                sumA+=1
        if sery == 'B':
            if random() > abilityB:
                sumA += 1
                sery = 'A'
            else:
                sumB += 1
    print("甲队第{}场获取分数为: {}".format(num,sumA))
    print("乙队第{}场获取分数为: {}".format(num, sumB))
    return sumA, sumB

# 第四步
def oneMatch(abilityA, abilityB):
    one=1
    winA, winB=0, 0
    for _ in range(5):
        sumA,sumB=oneGame(one,abilityA,abilityB)
        if sumA>sumB:
            winB+=1
        else:
            winA+=1
        one+=1

        if winA==3 or winB==3:
            break
    return winA, winB

def jiChang(n,abilityA,abilityB):
    winA, winB=0, 0
    for _ in range(n):
        winA, winB=oneMatch(abilityA,abilityB)
        if winA>winB:
            winA+=1
        else:
            winB+=1
    return winA, winB
def printResult(num,winA,winB):
    print("比赛结束,共{}场比赛".format(num))
    print("甲队获取{}比赛胜利，占比{}".format(winA,winA/num))
    print("乙队获取{}比赛胜利，占比{}".format(winB, winB / num))

def main():
    abilityA,abilityB,num=getAbility()
    winA,winB=jiChang(num,abilityA,abilityB)
    printResult(num,winA,winB)

main()






