import sys
from collections import deque

k = int(input())

def bfs(node,color):
    global flag
    q = deque()
    color[node] = 1
    q.append(node)
    while q and flag == 'YES':
        cur = q.popleft()
       # route.append(cur)
        if g[cur]:
            neighbor = g[cur]
            neighbor.sort()
            for idx in neighbor:
                if color[idx] == 0:
                    q.append(idx)
                    color[idx] = color[cur] * -1
                else:
                    if color[idx] + color[cur] != 0:
                        flag = 'NO'
        
            

        
for _ in range(k):
    v, e = list(map(int, input().split(" ")))
    g = [[] for _ in range(v+1)]
    for i in range(e):
        v1, v2 = list(map(int, input().split(" ")))
        g[v1].append(v2)
        g[v2].append(v1)
       # print(g)
    global flag
    flag = 'YES'
    color = [0] * (v + 1)
    for idx in range(1,v+1):
        if color[idx] == 0:  
            start = idx
            bfs(start,color)
    answer = flag
    print(answer)
