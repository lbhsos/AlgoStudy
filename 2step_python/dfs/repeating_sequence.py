import math
a, p = input().split(" ")
length = len(a)
p = int(p)

idx = 0
def dfs(num, visit):
    length = len(num)
    s = 0
    for i in range(length):
        s+=math.floor(math.pow(int(num[i]),p))
    if s not in visit:
        visit.append(s)
        dfs(str(s), visit)
    else:
        global idx
        idx = visit.index(s)
        return
    
visit = []
visit.append(int(a))
dfs(a,visit)
print(visit)
print(idx)
