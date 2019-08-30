import math
k, n = list(map(int, input().split(" ")))
arr = []
for _ in range(k):
    arr.append(int(input()))
right = max(arr)
left = 1
ans = []
while left<=right:
    amount = 0
    mid = (left + right) // 2
    #print(left, right, mid)
    for i in range(k):
        amount += (arr[i] // mid)
    if amount >= n:
        left = mid + 1
        ans.append(mid)
    else:
        right = mid - 1
        
print(max(ans))
    
