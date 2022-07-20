import sys
import math

n = int(sys.stdin.readline())
k = int(sys.stdin.readline())
d = [0] * (n+1) # d[i] = i*i 의 번호

closed_num = 0
for i in range(1,n+1):
    d[i] = (i-1) * n + i
    if d[i] > k:
        closed_num = i - 1
        break
# print(d)
def check(num):
    global n
    cnt = 0
    for i in range(1,n+1):
        cnt += min(num // i, n)
    return cnt

cnt = 0
left, right = 0, n*n
answer = 0
while left <= right:
    mid = (left + right) // 2
    cnt = check(mid)

    if cnt < k:
        left = mid + 1
    elif cnt >= k:
        right = mid - 1
        answer = mid


print(answer)