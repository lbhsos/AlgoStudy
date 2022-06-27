L, R = map(int, input().split(" "))

lefts = list(map(int, str(L)))
rights = list(map(int, str(R)))

answer = 0
if len(lefts) != len(rights):
    answer = 0
    print(answer)
    exit()

if L == R:
    for i in lefts:
        if i == 8:
            answer += 1
else:
    eight = False
    for i, j in zip(lefts, rights):
        if i == 8 and j == 8:
            answer += 1
        if i == j:
            continue
        else:
            break

print(answer)