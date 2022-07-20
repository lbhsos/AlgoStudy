import sys
import math

n = int(sys.stdin.readline())
k = int(sys.stdin.readline())

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