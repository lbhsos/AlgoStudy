N, K =map(int, input().split(" "))
cnt = 0
while bin(N).count('1') > K:
    a = 2**(bin(N)[::-1].index('1'))
    cnt += a
    N += a
print(cnt)