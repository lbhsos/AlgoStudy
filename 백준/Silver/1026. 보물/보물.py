N = int(input())

A = list(map(int, input().split(" ")))
B = list(map(int, input().split(" ")))

A = sorted(A)
B = sorted(B, reverse=True)

answer = 0
for i in range(N):
    answer += (A[i] * B[i])

print(answer)