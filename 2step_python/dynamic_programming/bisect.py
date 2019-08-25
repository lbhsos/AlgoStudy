n = int(input())
arr = list(map(int, input().split(" ")))
up = [0] * (n+1)
down = [0] * (n+2)
up[1] = 1
down[-2] = 1
down[-1] = 0
for i in range(2, n+1):
    max_up = 0
    cur = arr[i-1]
    for j in range(i):
        if arr[j-1] < cur and up[j] > max_up:
            max_up = up[j]
    up[i] = max_up + 1
for i in range(n, 1,-1):
    max_down = 0
    cur = arr[i-1]
    for j in range(i+1,len(down)-1):
        if arr[j-1] < cur and down[j] > max_down:
            max_down = down[j]
    down[i] = max_down + 1

sum_arr = [x+y for x,y in zip(up, down)]
print(max(sum_arr)-1)
