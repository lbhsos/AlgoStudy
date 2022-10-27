N = int(input()) # 사람수
lefts = list(map(int, input().split(" ")))
positions = [0] * N
for i in range(N):
    left = lefts[i]
    for idx in range(N):
        if left == 0 and positions[idx] == 0:
            positions[idx] = str(i+1)
            break

        if positions[idx] == 0:
            left -= 1


print(' '.join(positions))
