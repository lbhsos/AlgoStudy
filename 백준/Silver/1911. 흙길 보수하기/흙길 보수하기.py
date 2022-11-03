import sys
n, l = list(map(int, sys.stdin.readline().split(" ")))

bridges = list()
for _ in range(n):
    s, e = list(map(int, sys.stdin.readline().split(" ")))
    bridges.append((s,e))

bridges.sort(key=lambda x:(x[0], x[1]))

idx = 0
cnt = 0
for i in range(n):
    if bridges[i][0] > idx:
        idx = bridges[i][0]
    if bridges[i][1] >= idx:
        while bridges[i][1] > idx:
            idx += l
            cnt += 1
print(cnt)