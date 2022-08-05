import sys
from itertools import permutations
from collections import defaultdict

n = int(sys.stdin.readline())
partitions = list(map(int, sys.stdin.readline().split(' ')))
answer = 0
def make_chart(permutation):
    prev = 0
    cnt = 0
    dp = [0] * n
    for i, num in enumerate(permutation):
        if i == 0:
            dp[i] = 0
        else:
            dp[i] = prev
        prev = prev + permutation[i]

    for i in range(i):
        cur_value = dp[i]
        for j in range(i+1, n):
            next_value = dp[j]
            if (cur_value + 50 == next_value):
                cnt += 1
                break
    return cnt


for permutation in permutations(partitions, n):
    answer = max(answer, make_chart(permutation))
    # print(permutation, answer)
print(answer)