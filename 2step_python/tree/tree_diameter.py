from collections import deque
import pprint
n = int(input())
tree = {}
def make_tree(n1, n2, dist):
    if n1 in tree:
        tree[n1].append({'node':n2, 'dist': dist})
    else:
        tree[n1] = [{'node':n2, 'dist': dist}] 
        
for _ in range(n-1):
    par, child, dist = list(map(int, input().split(" ")))
    make_tree(par,child,dist)
    make_tree(child,par,dist)
    

def bfs(num):
    q = deque()
    q.append(num)
    visit[num] = 0
    while q:
        cur = q.popleft()
#         if cur in tree.keys():
        next_arr = tree[cur]
        for i in range(len(next_arr)):
            next_node = next_arr[i]['node']
            next_dist = next_arr[i]['dist']
            if visit[next_node] == -1:
                visit[next_node] = next_dist + visit[cur]
                q.append(next_node)
visit = [-1] * (n+1)
bfs(1)

idx = visit.index(max(visit))
visit = [-1] * (n+1)
bfs(idx)

print(max(visit))
