import sys
n = int(sys.stdin.readline())
tasks = list()

for i in range(n):
    ts = list(map(int, input().split()))
    tasks.append(ts)

tasks.sort(key=lambda x: (x[1], x[0]))
total_time = 0
for i in tasks:
    total_time += i[0]

daytime = 1000000
if total_time > daytime:
    print(-1)
    exit()

start_time = -1
for i in range(daytime, -1, -1):
    possible = True
    cur_time = i
    for j in tasks:
        if cur_time + j[0] > j[1]:
            possible = False
            break
        cur_time += j[0]
    if possible:
        start_time = i
        break
print(start_time)