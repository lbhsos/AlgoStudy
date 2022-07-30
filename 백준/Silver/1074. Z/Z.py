import math
import sys

n, row, col = list(map(int, sys.stdin.readline().split(" ")))
answer = 0
def calculate(row, col):
    if row == 0 and col == 0:
        return 0
    elif row == 0 and col == 1:
        return 1
    elif row == 1 and col == 0:
        return 2
    else:
        return 3

def solve(row, col, std):
    global answer
    if 0 <= row <= 1 and 0 <= col <= 1:
        answer += calculate(row, col)
        return answer
    prev_std = std // 2
    base = prev_std * prev_std
    if 0 <= row < prev_std and 0 <= col < prev_std:
        answer += (base) * 0
        return solve(row, col, prev_std)
    elif 0 <= row < prev_std and prev_std <= col < std:
        answer += (base) * 1
        return solve(row, col - prev_std, prev_std)
    elif 0 <= col < prev_std and prev_std <= row < std:
        answer += (base) * 2
        return solve(row-prev_std, col, prev_std)
    elif prev_std <= row < std and prev_std <= col < std:
        answer += (base) * 3
        return solve(row-prev_std, col-prev_std, prev_std)

solve(row, col, int(math.pow(2, n)))
print(answer)
