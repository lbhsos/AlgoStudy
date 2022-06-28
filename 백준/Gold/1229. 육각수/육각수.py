import sys

sys.setrecursionlimit(10000)
n = int(input())

INF = 10 ** 9
d = [0, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 2] + [INF] * 1000000


def get_hex(limit):  
    n = 1
    current = 0
    ans = []
    while current <= limit:
        current = n * (2 * n - 1)
        ans.append(current)
        n += 1
    return ans[:-1]



if n < 13:
    print(d[n])
    exit()

hex = get_hex(n)
for i in range(13, n + 1):
    min_val = INF
    for h in hex:
        if h > i: break
        min_val = min(min_val, d[i - h])
    d[i] = min_val + 1
print(d[n])

