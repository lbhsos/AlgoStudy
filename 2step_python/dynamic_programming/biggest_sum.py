n = int(input())
arr = list(map(int,input().split(" ")))
cache = [0] * (n+1)
cache[1] = arr[0]
count = 1

for i in range(2,n+1):
    cur = arr[i-1]
    max_num = 0
    for j in range(1,i):
        if cur > arr[j-1] and cache[j] > max_num:
            max_num = cache[j]
    cache[i] = max_num + cur
print(max(cache))

