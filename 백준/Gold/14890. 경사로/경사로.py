N, L = map(int, input().split(" "))

grids = list()
for _ in range(N):
    grids.append(list(map(int, input().split(" "))))

cnt = 0
def find_col():
    global cnt
    for j in range(N):
        prev = 0
        same_level = 1

        i = -1
        while i < N:
            if i == N - 1:
                cnt += 1
                break

            i += 1
            if i == 0:
                prev = grids[i][j]
                continue

            cur = grids[i][j]
            diff = abs(prev - cur)
            if diff > 1:
                break

            if prev > cur:
                same_level = 0
                flag = True
                if i+L-1 >= N:
                    break

                for tmp_i in range(i, i+L):
                    if cur != grids[tmp_i][j]:
                        flag = False
                        break

                if not flag:
                    break
                i = i + L - 1

            elif prev < cur:
                if same_level < L:
                    break
                same_level = 1
            else:
                same_level += 1
            prev = cur


def find_row():
    global cnt
    for i in range(N):
        prev = 0
        same_level = 1
        j = -1
        while j < N:
            if j == N-1:
                cnt += 1
                break

            j += 1
            if j == 0:
                prev = grids[i][j]
                continue

            cur = grids[i][j]
            diff = abs(prev - cur)
            if diff > 1:
                break

            if prev > cur:
                same_level = 0
                flag = True
                if j + L - 1 >= N:
                    break

                for tmp in range(j, j + L):
                    if cur != grids[i][tmp]:
                        flag = False
                        break

                if not flag:
                    break
                j = j + L - 1
            elif prev < cur:
                if same_level < L:
                    break
                same_level = 1
            else:
                same_level += 1
            prev = cur


find_col()
find_row()
print(cnt)
