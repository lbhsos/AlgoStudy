n = int(input())
wine = [0] * (10001)
for i in range(1,n+1):
    wine[i] = int(input())

cache = [0] * (10001)
cache[1] = wine[1]
cache[2] = wine[1]+wine[2]

for i in range(3, n+1):
    cache[i] = max(cache[i-1], cache[i-2]+wine[i], cache[i-3]+wine[i-1]+wine[i])
    

print(cache[n])

