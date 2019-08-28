from collections import deque

n = int(input())
g = [[] for _ in range(n)]
for i in range(n):
    g[i] = list(input())
visit = [[False] * n for _ in range(n)]
count = 0
arr = []

def bfs(i,j):
    q = deque()
    c = 0
    q.append([i,j])
    visit[i][j] = True
    while q:
        c+=1
        #print(c)
        cur = q.popleft()
        cur_i = cur[0]
        cur_j = cur[1]
        pos = [[-1,0],[0,+1],[+1,0],[0,-1]]
        for k in range(4):
            next_i = pos[k][0] + cur_i
            next_j = pos[k][1] + cur_j
            if next_i < n and next_i > -1 and next_j < n and next_j > -1:
                if not visit[next_i][next_j] and g[next_i][next_j] == '1':
                    visit[next_i][next_j] = True
                    q.append([next_i, next_j])
   # print(c)
    arr.append(c)

for i in range(n):
    for j in range(n):
        if not visit[i][j] and g[i][j] == '1':
            bfs(i,j)
            count += 1
            
arr.sort()   
print(len(arr))
for i in range(len(arr)):
    print(arr[i])
