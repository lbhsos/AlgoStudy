N, M = list(map(int, input().split(" ")))

answer = 0

while True:
    if N < M:
        if (M%N ==0):
            answer += (N * (M // N -1))
        else:
            answer += (N * (M // N))
        M = M % N
    elif N >= M:
        N = N % M
    if M == 1 or N == 0 or M == 0:
        break
print(answer)