import sys
import copy
sys.setrecursionlimit(10**6)

text = list(input().strip())

MAX = 100
n = len(text)

def make_dp(left, right, s):
    global dp

    if dp[left][right] != -1:
        return dp[left][right]
    if left >= right:
        return 0

    dp[left][right] = min((make_dp(left+1, right, s) + 1),
                          (make_dp(left, right-1, s) + 1),
                          (make_dp(left+1, right-1, s) + (s[left] != s[right]))
                          )
    return dp[left][right]
ans = float('inf')
for i in range(n):
    for j in range(i+1, n):
        dp = [[-1] * MAX for _ in range(MAX)]
        temp_s = copy.deepcopy(text)
        temp_s[i], temp_s[j] = temp_s[j], temp_s[i]
        ans = min(ans, make_dp(0, n-1, temp_s) + 1)

dp = [[-1] * MAX for _ in range(MAX)]
ans = min(ans, make_dp(0, n-1, text))
print(f'{ans}')
