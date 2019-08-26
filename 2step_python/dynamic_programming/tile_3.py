n = int(input())

way = {0:1, 1:0, 2:3, 3:0,4:11}

for i  in range(5,n+1):
    if i % 2 == 1:
        way[i] = 0
    else:
        way[i] = way[i-2] * 3
        for j in range(i,3,-2):
            way[i] += way[i-j]*2
#print(way)
print(way[n])
