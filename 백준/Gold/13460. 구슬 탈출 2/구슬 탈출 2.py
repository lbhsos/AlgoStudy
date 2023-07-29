from collections import defaultdict

n, m = map(int, input().split())
puzzles = list()
EMPTY, WALL, DEST ='.', '#', 'O'
R, B = 'R', 'B'

row_walls, col_walls = defaultdict(list), defaultdict(list)

for i in range(n):
    row = list(input())
    for j, value in enumerate(row):
        if value == R:
            pos_red = (i, j)
        elif value == B:
            pos_blue = (i, j)
        elif value == DEST:
            dest_row, dest_col = i,j
        elif value == WALL:
            row_walls[i].append(j)
            col_walls[j].append(i)
answer = float('inf')

def move_right(red_row, red_col, blue_row, blue_col, count):
    global answer
    org_red, org_blue = red_col, blue_col
    for idx_col in row_walls[blue_row]:
        if idx_col < blue_col:
            continue
        if blue_col < dest_col < idx_col and blue_row == dest_row:
            return
        blue_col = idx_col - 1
        break

    for idx_col in row_walls[red_row]:
        if idx_col < red_col:
            continue
        if red_col < dest_col < idx_col and red_row == dest_row:
            answer = min(answer, count)
            return
        red_col = idx_col - 1
        break

    if red_row == blue_row and red_col == blue_col:
        if org_red < org_blue:
            red_col -= 1
        else:
            blue_col -= 1

    if count >= 10:
        return
    move(3, red_row, red_col, blue_row, blue_col, count)


def move_left(red_row, red_col, blue_row, blue_col, count):
    global answer
    org_red, org_blue = red_col, blue_col

    for idx in list(reversed(row_walls[blue_row])):
        if idx > blue_col:
            continue
        if idx < dest_col < blue_col and blue_row == dest_row:
            return
        blue_col = idx + 1
        break

    for idx in list(reversed(row_walls[red_row])):
        if idx > red_col:
            continue
        if idx < dest_col < red_col and red_row == dest_row:
            answer = min(answer, count)
            return
        red_col = idx + 1
        break

    if red_row == blue_row and red_col == blue_col:
        if org_red < org_blue:
            blue_col += 1
        else:
            red_col += 1
    if count >= 10:
        return
    move(2, red_row, red_col, blue_row, blue_col, count)

def move_up(red_row, red_col, blue_row, blue_col, count):
    global answer
    org_red, org_blue = red_row, blue_row

    for idx in list(reversed(col_walls[blue_col])):
        if idx > blue_row:
            continue
        if idx < dest_row < blue_row and dest_col == blue_col:
            return
        blue_row = idx + 1
        break

    for idx in list(reversed(col_walls[red_col])):
        if idx > red_row:
            continue
        if idx < dest_row < red_row and dest_col == red_col:
            answer = min(answer, count)
            return
        red_row = idx + 1
        break

    if red_col == blue_col and red_row == blue_row:
        if org_red < org_blue:
            blue_row += 1
        else:
            red_row += 1

    if count >= 10:
        return
    move(0,red_row, red_col, blue_row, blue_col, count)

# (y == col, x == row)
def move_down(red_row, red_col, blue_row, blue_col, count):
    global answer
    org_red, org_blue = red_row, blue_row
    for idx in col_walls[blue_col]:
        if idx < blue_row:
            continue
        if idx > dest_row > blue_row and dest_col == blue_col:
            return
        blue_row = idx - 1
        break

    for idx in col_walls[red_col]:
        if idx < red_row:
            continue
        if idx > dest_row > red_row and dest_col == red_col:
            answer = min(answer, count)
            return
        red_row = idx - 1
        break

    if red_col == blue_col and red_row == blue_row:
        if org_red < org_blue:
            red_row -= 1
        else:
            blue_row -= 1

    if count >= 10:
        return
    move(1, red_row, red_col, blue_row, blue_col, count)


def move(direction, red_x, red_y, blue_x, blue_y, count):
    count += 1
    for i in range(4):
        if i==0 and i != direction:
            move_up(red_x, red_y, blue_x, blue_y, count)
        elif i==1 and i != direction:
            move_down(red_x, red_y, blue_x, blue_y, count)
        elif i==2 and i != direction:
            move_left(red_x, red_y, blue_x, blue_y, count)
        elif i==3 and i != direction:
            move_right(red_x, red_y, blue_x, blue_y, count)




move(-1, pos_red[0], pos_red[1], pos_blue[0], pos_blue[1], 0)
if answer == float('inf'):
    answer = -1
print(answer)