import sys
sys.setrecursionlimit(10000)

n, m = list(map(int, input().split(" ")))
g = [[] for _ in range(n+1)]
for i in range(m):
    v1, v2 = list(map(int, input().split(" ")))
    g[v1].append(v2)
    g[v2].append(v1)
visit = []
def dfs(idx):
    # 이웃 & not in visit
    neighbor = g[idx]
    if neighbor:
        for node in neighbor:
            if node not in visit:
                visit.append(node)
                dfs(node)
count = 0
for idx in range(1,n+1):
    if idx not in visit:
        count+=1
        visit.append(idx)
        dfs(idx)
print(g)
print(count)
    
