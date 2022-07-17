import sys
limit_number = 15000
sys.setrecursionlimit(limit_number)
n = int(sys.stdin.readline())
times = [0] * n
costs = [0] * n
dp = [0] * n # i 일째 얻을 수 있는 최대 날짜.

for i in range(n):
    times[i], costs[i] = list(map(int, sys.stdin.readline().split(" ")))

max_time = float('-inf')
for i in range(n-1, -1, -1):
    if i + times[i] > n:
        dp[i] = dp[min(i+1, n-1)]
        continue

    if i == n - 1:
        dp[i] = costs[i]
        max_time = dp[i]
        continue

    next_idx = i + times[i]
    if next_idx >= n:
        next_time = 0
    else:
        next_time = dp[next_idx]

    if (costs[i] + next_time > max_time):
        dp[i] = costs[i] + next_time
        max_time = dp[i]
    else:
        dp[i] = max_time
print(dp[0])
