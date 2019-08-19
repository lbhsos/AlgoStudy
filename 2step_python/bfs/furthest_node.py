from collections import deque
import pprint

MAP={}
def solution(n, edge):
    answer = 0
    global MAP
    visit = [False] * n
    
    for e in edge:
        v1 = e[0] - 1
        v2 = e[1] - 1
        makeDict(v1,v2)
        makeDict(v2,v1)
        
    q = deque()
    q.append(0)
    q.append(None)
    visit[0] = True
    count=0

    while True:
        current_node = q.popleft()
        if current_node == None:
            q.append(None)
            if q[0] == None:
                break
            else:
                current_node = q.popleft()
                answer=count
                count=0

        for node in MAP[current_node]:
            if visit[node] == False:
                q.append(node)
                visit[node] = True
                count+=1
            
    return answer

def makeDict(v1, v2):
    if v1 not in MAP:
        MAP[v1] = [v2]
    else:
        temp = MAP.get(v1)
        temp.append(v2)
        MAP[v1] = temp

