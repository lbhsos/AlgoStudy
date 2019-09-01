n, c = list(map(int, input().split(" ")))
pos = [0] * (c)
home = []
for _ in range(n):
    home.append(int(input()))
home.sort()
left = home[0]
right = home[-1]
max_len = 0
while left <= right:
    mid = (left+right)//2 # 물리적인 간격 
    #print(left, right, mid, max_len)
    cnt = 1
    start = home[0]
        # 1 2 4 8 9
    for i in range(1,n):
        #print(home[i], start, mid)
        if home[i] - start >= mid:
            cnt+=1
            start = home[i]
    if cnt >= c:
        max_len = mid
        left = mid + 1
        #print(left, right, max_len)
    else:
        right = mid - 1
    

print(max_len)
