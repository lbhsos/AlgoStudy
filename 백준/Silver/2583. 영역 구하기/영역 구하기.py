from collections import deque

M, N, K = map(int, input().split(" "))

grounds = [[0 for _ in range(N)] for _ in range(M)]
visited = [[False for _ in range(N)] for _ in range(M)]
WALL = 1

def fill_grounds(x1, y1, x2, y2):
    for i in range(M-y2, M-y1):
        for j in range(x1, x2):
            grounds[i][j] = WALL

for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split(" "))
    fill_grounds(x1, y1, x2, y2)

def bfs(initI, initJ):
    q = deque()
    visited[initI][initJ] = True
    q.append((initI, initJ))
    area = 1

    while q:
        curI, curJ = q.popleft()
        nextPos = [(-1, 0), (0, +1), (+1, 0), (0, -1)]
        for idx in range(4):
            nextI, nextJ = curI + nextPos[idx][0], curJ + nextPos[idx][1]
            if nextI >= 0 and nextI < M and nextJ >= 0 and nextJ < N:
                if not visited[nextI][nextJ] and grounds[nextI][nextJ] != WALL:
                    visited[nextI][nextJ] = True
                    area += 1
                    q.append((nextI, nextJ))
    return area

answers = list()
for i in range(M):
    for j in range(N):
        if not visited[i][j] and grounds[i][j] != WALL:
            answers.append(bfs(i, j))

print(len(answers))
print(*sorted(answers))

