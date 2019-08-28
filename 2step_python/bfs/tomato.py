from collections import deque

col, row = list(map(int, input().split(" ")))
box = [[] for _ in range(row)]
visit = [[False] * col for _ in range(row)]
for i in range(row):
    box[i] = list(map(int,input().split(" ")))

q = deque()
day = 0
def bfs():
    global q
    global visit
    global box
    global day
    pos = [[-1,0],[+1,0],[0,+1],[0,-1]]
    while q:
        cur = q.popleft()
        if cur == None:
            day += 1
            #print(day)
            #print(q)
            q.append(None)
            if q[0] == None:
                break
        else:
            for i in range(len(pos)):
                next_i = cur[0] + pos[i][0]
                next_j = cur[1] + pos[i][1]
                if next_i < row and next_j < col and next_i > -1 and next_j > -1:
                   # print(next_i, next_j, 'next')
                    if not visit[next_i][next_j] and box[next_i][next_j] == 0:
                        visit[next_i][next_j] = True
                        box[next_i][next_j] = 1
                        q.append([next_i,next_j])
    return (day - 1) if all(0 not in row for row in box) else -1


for i in range(row):
    for j in range(col):
        if box[i][j] == 1 and not visit[i][j]:
            q.append([i,j])
            visit[i][j] = True
q.append(None)
day = bfs()


print(day)
