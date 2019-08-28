from collections import deque

n, m = list(map(int, input().split(" ")))
g = [[] for _ in range(n)]
visit = [[False] * m for _ in range(n)]
for i in range(n):
    g[i] = list(map(int,list(input())))
    
def bfs():
    q = deque()
    q.append([0,0])
    visit[0][0] = True
    q.append(None)
    count =1
    while q:
        cur = q.popleft()
        if cur == None:
            q.append(None)
            count+=1
            if q[0] == None:
                break
        else:
            if cur[0] == n-1 and cur[1] == m-1:
                return count
            pos_arr = [[-1,0],[0,+1],[+1,0],[0,-1]]
            for k in range(len(pos_arr)):
                next_i = pos_arr[k][0] + cur[0]
                next_j = pos_arr[k][1] + cur[1]
                if next_i < n and next_j < m and next_i > -1 and next_j > -1:
                    if g[next_i][next_j] == 1 and not visit[next_i][next_j]:
                        visit[next_i][next_j] = True
                        q.append([next_i,next_j])

answer = bfs()
print(answer)

