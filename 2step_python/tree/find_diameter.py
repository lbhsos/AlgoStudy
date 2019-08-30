import pprint
from collections import deque

n = int(input())
connect = {}
for i in range(1,n+1):
    connect[i] = []

for i in range(n):
    line = list(map(int, input().split(" ")))
    for j in range(1,len(line)-1,+2):
        connect[line[0]].append({'node': line[j],'dist':line[j+1]})

def bfs(num):
  #  cache = [0] * (n+1)
    q = deque()
    q.append(num)
    visit[num] = 0
    while q:
        cur = q.popleft()
        next_arr = connect[cur]
        for i in range(len(next_arr)):
            next_num = next_arr[i]['node']
            next_dist = next_arr[i]['dist']
            if visit[next_num] == -1:
                visit[next_num] = next_dist + visit[cur]
                q.append(next_num)
                
visit = [-1] * (n+1)
bfs(1)
idx = visit.index(max(visit))
visit = [-1] * (n+1)
bfs(idx)
answer = max(visit)
print(answer)
#pprint.pprint(connect)
