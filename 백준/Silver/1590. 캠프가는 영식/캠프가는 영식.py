import sys
import heapq

n, t = map(int, sys.stdin.readline().split(" "))
buses = list()



for _ in range(n):
    start_time, interval, count = map(int, sys.stdin.readline().split(" "))
    for i in range(count):
        next_time = start_time + (interval * i)
        if next_time >= t:
            heapq.heappush(buses, next_time)

answer = -1
while len(buses) > 0:
    next_time = heapq.heappop(buses)
    answer = next_time - t
    break
print(answer)
