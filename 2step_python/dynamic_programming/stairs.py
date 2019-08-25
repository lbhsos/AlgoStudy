n = int(input())
arr = [0] * (n+1)
for i in range(1,n+1):
    arr[i] = int(input())
cache = [0] * (n+1)
cache[-1] = arr[-1]
cache[-2] = cache[-1] + arr[-2]
cache[-3] = arr[-1] + arr[-3]
for j in range(n-3,0,-1):
    cache[j] = max(cache[j+3]+arr[j+1]+arr[j], cache[j+2]+arr[j])

# print(cache[1:])
print(max(cache[1], cache[2]))

