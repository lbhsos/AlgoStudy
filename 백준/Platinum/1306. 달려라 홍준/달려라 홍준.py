import sys
from collections import deque

N, M = list(map(int, sys.stdin.readline().split()))
lights = list(map(int, sys.stdin.readline().split()))

window = deque(lights[:2 * M - 1])
mx = max(window)
answer = [str(mx)]

for i in range(2 * M - 1, N):
    window.append(lights[i])
    temp = window.popleft()
    if lights[i] > mx:
        mx = lights[i]
    elif temp == mx:
        mx = max(window)

    answer.append(str(mx))
print(' '.join(answer))
