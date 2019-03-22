from queue import Queue
from pprint import pprint
from collections import defaultdict
import itertools

hyper_map = defaultdict(set)


def bfs(source, destination, N):
    q = Queue()
    visited = [False for _ in range(N+1)]

    q.put(source)
    visited[source] = True

    dummy = -9999
    q.put(dummy)

    level = 0
    
    while not q.empty():
        next = q.get()

        if next == dummy:
            level += 1
            q.put(dummy)
            continue

        if next == destination:
            return level + 1
        
        if next not in hyper_map.keys():
            return -1
        
        for naver in hyper_map[next]:
            if not visited[naver]:
                q.put(naver)
                visited[naver] = True
    return -1

N, K, M = list(map(int, input("").split(' ')))
source = 0
destination = 0
for m in range(M):
    line = list(map(int, input("").split(' ')))
    
    if m is 0: 
        source = line[0]
    if m is M-1:
        destination = line[K-1]
    for (i, j) in itertools.permutations(range(K), 2):
        hyper_map[line[i]].add(line[(i + 1) % K])
        hyper_map[line[(i + 1) % K]].add(line[i])
pprint(hyper_map)

print(bfs(source, destination, N))


# print(bfs(source, destination, N))