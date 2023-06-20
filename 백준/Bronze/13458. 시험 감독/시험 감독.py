import math

N = int(input())
takers = list(map(int, input().split(" ")))
B, C = map(int, input().split(" "))
sorted_takers = sorted(takers, reverse=True)
answer = N
for i in range(N):
    sorted_takers[i] = max(sorted_takers[i] - B, 0)

for i in range(N):
    answer += math.ceil(sorted_takers[i] / C)

print(answer)