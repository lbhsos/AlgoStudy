t = int(input())
for _ in range(t):
    n = int(input())
    way={1:1, 2: 2, 3: 4}

    for i in range(4,n+1):
        way[i] = way[i-1] +way[i-2] + way[i-3] 
    print(way[n])
