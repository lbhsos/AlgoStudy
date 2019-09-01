import sys
sys.setrecursionlimit(10**6)

n, m = list(map(int, input().split(" ")))
tree = list(map(int, input().split(" ")))
right = max(tree)
left = 1
answer = 0

while left <= right:
    mid = (left + right)//2
    rest = 0
    for i in range(n):
        rest += max(tree[i] - mid,0)
    if rest >= m:
        left = mid+1
        answer = max(mid,answer)
    else:
        right = mid-1
        

print(answer)
