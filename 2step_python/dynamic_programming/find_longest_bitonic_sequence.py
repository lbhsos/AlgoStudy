import heapq

N = int(input())
input_list = list(map(int, input().split(" ")))

## arr 2개 사용 
dp = [0] * N
dp_down = [0] * N

## 최장 오름차순 찾기 
def LIS(k):
    global dp, input_list
    if dp[k] == 0:
        dp[k] = 1
        
        for i in range(k-1, -1, -1):
            if input_list[i] < input_list[k]:
                dp[k] = max(dp[k], LIS(i) + 1)
    return dp[k]

## 최장 내림차순
def LDS(k):
    global dp_down, input_list
    if dp_down[k] == 0:
        dp_down[k] = 1
        
        for i in range(k+1, N, +1):
            if input_list[i] < input_list[k]:
                dp_down[k] = max(dp_down[k], LDS(i) + 1)
    return dp_down[k]


for i in range(N):
    LIS(i)
    LDS(i)

answer = 0
for left, right in zip(dp, dp_down):
    answer = max(answer, (left+right-1))
print(answer)
