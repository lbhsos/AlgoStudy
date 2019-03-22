from pprint import pprint
from collections import defaultdict
import sys
sys.setrecursionlimit(100000)

graph = defaultdict(list)
visited = []
red_green_visited = []
area = []


def find_start(visited_in, N):
    for i in range(N):
        for j in range(N):
            if visited_in[i][j] is False:
                return (i, j)
    return None


def dfs(visited_dfs, point, mode, isRedGreen=False):
    visited_dfs[point[0]][point[1]] = True
    
    for naver in graph[point]:
        if area[naver[0]][naver[1]] is mode:
            if not visited_dfs[naver[0]][naver[1]]:
                visited_dfs = dfs(visited_dfs, naver, mode, isRedGreen)
        elif isRedGreen and mode is not 'B' and \
                area[naver[0]][naver[1]] is not 'B':
            if not visited_dfs[naver[0]][naver[1]]:
                visited_dfs = dfs(visited_dfs, naver, mode, isRedGreen)

    return visited_dfs

N = int(input(""))
for _ in range(N):
    area.append(list(input("")))

for i in range(N):
    visited.append([])
    red_green_visited.append([])
    for j in range(N):
        if i > 0:
            graph[(i, j)].append((i-1, j))
        if j > 0:
            graph[(i, j)].append((i, j-1))
        if i < N-1:
            graph[(i, j)].append((i+1, j))
        if j < N-1:
            graph[(i, j)].append((i, j+1))
        
        visited[i].append(False)
        red_green_visited[i].append(False)

count = 0
while find_start(visited, N) is not None:
    start = find_start(visited, N)
    visited = dfs(visited, 
                  start,
                  area[start[0]][start[1]], False)
    count += 1

RGcount = 0
while find_start(red_green_visited, N) is not None:
    start = find_start(red_green_visited, N)
    red_green_visited = dfs(red_green_visited, 
                            start,
                            area[start[0]][start[1]], True)
    RGcount += 1

print(count, RGcount)