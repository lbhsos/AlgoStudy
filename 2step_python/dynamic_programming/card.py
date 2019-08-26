n = int(input())
p = [0] * (n+1)
p[1:] = list(map(int, input().split(" ")))
cache = [0] * (n+1)
cache[1] = p[1]

for i in range(2, n+1):
    temp = p[i]
    for j in range(1,i//2+1):
        temp = max(cache[i-j] + cache[j] , temp)
    cache[i] = temp
print(cache[n])
