from collections import deque

n = int(input())
tree={1:0}
connect = {}
def make_dictionary(v1, v2):
    if v1 in connect:
        connect[v1].append(v2)
    else:
        connect[v1] = [v2]
        
for i in range(n-1):
    v1, v2 = list(map(int,input().split(" ")))
    make_dictionary(v1,v2)
    make_dictionary(v2,v1)

visit = [0] * (n+1)

q = deque()
visit[1] = 1
q.append(1)

while q:
    cur_num = q.popleft()
    next_arr = connect[cur_num]
    #print(cur_num, next_arr)
    for i in range(len(next_arr)):
        if visit[next_arr[i]] == 0:
            tree[next_arr[i]] = cur_num
            q.append(next_arr[i])
            visit[next_arr[i]] = 1
        
for i in range(2,n+1):
    print(tree[i])
