from queue import Queue
from pprint import pprint

def bfs(A, B, source, destination):
    visited = [False] * 100001
    q = Queue()
    q.put(source)
    visited[source] = True

    dummy = -999999
    q.put(dummy)

    level = 0

    while not q.empty():
        next = q.get()
        
        if next == dummy:
            level += 1
            q.put(dummy)
            continue

        if next == destination:
            return level
        
        navers = [next+1,next-1,next+A,next+B,next-A,next-B,next*A,next*B]
        for naver in navers:
            if naver <= 100000 and naver >= 0 :
                if not visited[naver]:
                    q.put(naver)
                    visited[naver] = True


A, B, N, M = list(map(int, input("").split(' ')))

print(bfs(A,B,N,M))
