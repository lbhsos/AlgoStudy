import sys

n = int(sys.stdin.readline())
dp = [[0] * 3 for _ in range(n)]
R,G,B =0,1,2

for i in range(n):
    r,g,b = map(int, sys.stdin.readline().split(" "))
    if i == 0:
        dp[0][R], dp[0][G], dp[0][B] = r, g, b
        continue
    dp[i][R] = min(dp[i - 1][G], dp[i - 1][B]) + r
    dp[i][G] = min(dp[i - 1][R], dp[i - 1][B]) + g
    dp[i][B] = min(dp[i - 1][R], dp[i - 1][G]) + b


print(min(dp[n-1]))