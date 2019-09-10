import sys

n = int(input())
times = list(map(int, input().split(" ")))
times.sort()

answer = 0
time_for_person = 0
for i in range(n):
    time_for_person += times[i]
    answer += time_for_person
print(answer)
