import sys
from itertools import product

sys.setrecursionlimit(10**5)

row, col = list(map(int, sys.stdin.readline().split(" ")))
num_arr = []
for _ in range(row):
    num_arr.append(list(sys.stdin.readline()[:-1]))

answer = float('-inf')
squares = dict()
def is_perfect_square(text):
    global answer

    if text in squares:
        return

    num = int(text)
    temp = num ** 0.5
    if int(temp) == temp:
        answer = max(answer, num)
        squares[text] = True


def solve(row_idx, col_idx, row_diff, col_diff, text):
    global num_arr, row, col

    next_row_idx = row_idx + row_diff
    next_col_idx = col_idx + col_diff

    if 0 <= next_col_idx < col and 0 <= next_row_idx < row:
        is_perfect_square(text + num_arr[next_row_idx][next_col_idx])
        solve(next_row_idx, next_col_idx, row_diff, col_diff, text + num_arr[next_row_idx][next_col_idx])

diff_rows = [i for i in range(-row,row)]
diff_cols = [i for i in range(-col,col)]

for row_diff, col_diff in product(diff_rows, diff_cols):
    if row_diff == 0 and col_diff == 0:
        continue

    for i in range(row):
        for j in range(col):
            is_perfect_square(num_arr[i][j])
            solve(i, j, row_diff, col_diff, num_arr[i][j])

if row == 1 and col == 1:
    is_perfect_square(num_arr[0][0])

if answer == float('-inf'):
    answer = -1

print(answer)