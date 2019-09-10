from queue import PriorityQueue
import sys

n = int(sys.stdin.readline().strip())
q = PriorityQueue()

for item in range(n):
    item = list(map(int, sys.stdin.readline().split(" ")))
    q.put((item[0], item))


prev = q.get()[1]
start = prev[0]
end = prev[1]
count=1
# 제일 빨리 시작하는 것부터
for idx in range(1,n):
    cur = q.get()[1]
    if cur[0] > start and cur[1] < end:
        start = cur[0]
        end = cur[1]
    elif cur[0] >= end:
        start = cur[0]
        end = cur[1]
        count+=1
    else:
        continue   
    
# 해당 막대기보다 작은 것으로 배정
print(count)   
