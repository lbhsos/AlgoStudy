from collections import deque
import sys
m,n = map(int, sys.stdin.readline().split(" "))

arr = list()
visited = [[False] * m for _ in range(n)]
for _ in range(n):
    arr.append(list(sys.stdin.readline()[:-1]))

white_sum, black_sum = 0, 0
def bfs(cur_i, cur_j, color):
    global white_sum, black_sum, visited, n, m
    cnt = 0
    combination = [(0,-1), (-1,0), (0,+1), (+1,0)]
    q = deque()
    q.append((cur_i,cur_j))

    while q:
        i, j = q.popleft()
        cnt += 1
        for row, col in combination:
            next_i, next_j = i + row, j+col
            if 0 <= next_i < n and 0 <= next_j < m:
                if color == arr[next_i][next_j] and not visited[next_i][next_j]:
                    visited[next_i][next_j] = True
                    q.append((next_i, next_j))

    if color == 'W':
        white_sum += (cnt ** 2)
    else:
        black_sum += (cnt **2)

for i in range(n):
    for j in range(m):
        if not visited[i][j]:
            visited[i][j] = True
            bfs(i, j, arr[i][j])
print(white_sum, black_sum)