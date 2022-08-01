import sys
import heapq

row, col, num = list(map(int, sys.stdin.readline().split(" ")))

arr = []
for _ in range(row):
    arr.append(list(sys.stdin.readline()[:-1]))
answer = 0
def dfs(i, j, visited, cnt):
    global arr, num, answer
    if cnt == num and (i, j) == (0, col-1):
        answer += 1
        return
    # 위, 오른쪽, 아래, 왼쪽
    positions = {(-1,0), (0,+1), (+1,0), (0, -1)}
    for position in positions:
        next_i = i + position[0]
        next_j = j + position[1]
        if (next_i, next_j) not in visited and (0 <= next_i < row and 0 <= next_j < col):
            if arr[next_i][next_j] == 'T':
                continue
            dfs(next_i, next_j, visited + [(next_i, next_j)], cnt + 1)


start_i, start_j = row-1, 0
dfs(start_i, start_j, [(start_i, start_j)], 1)

print(answer)