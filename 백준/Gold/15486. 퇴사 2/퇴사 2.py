from sys import stdin
N = int(stdin.readline())

t, p, dp = [0] * N, [0] * N, [0] * (N+1)
for i in range(N):
    t[i], p[i] = list(map(int, stdin.readline().split(" ")))

for i in range(N-1, -1, -1):
    if i + t[i] >= N+1:
        dp[i] = dp[i+1]
        continue

    dp[i] = max(dp[i+t[i]] + p[i], dp[i+1])

print(dp[0])
