r1, c1, r2, c2 = map(int, input().split(" "))

max_abs = max(abs(r1), abs(r2), abs(c1), abs(c2))
N = max_abs * 2 + 1

## calculate index
def convert_to_arr_idx(num, N):
    if num < 0:
        abs_num = abs(num)
        return N // 2 - abs_num
    elif num >= 0:
        return N // 2 + num

r1 = convert_to_arr_idx(r1, N)
c1 = convert_to_arr_idx(c1, N)
r2 = convert_to_arr_idx(r2, N)
c2 = convert_to_arr_idx(c2, N)

max_num = float('-inf')
width, height = c2 - c1 + 1, r2 - r1 + 1

def fill_array(N):
    global max_num, width, height
    arr = [[0] * width for _ in range(height)]
    middle = N//2

    # 이동방법: 오른, 위, 왼, 아래
    moving_method = [(0, 1), (-1, 0), (0, -1), (1, 0)]
    cur_moving_method = 0

    # 순열 계산을 위한 변수들
    times = 1
    next_moving_change_value = 2
    diff = 1

    ## 가상의 cursor
    row, col = middle, middle

    for i in range(1, N*N+1):
        if (r1 <= row <= r2) and ( c1 <= col <= c2):
            max_num = max(max_num, i)
            arr[row-r1][col-c1] = i

        ## 다음에 이동 방법이 변경되는 지점 구하기
        if (i == next_moving_change_value):
            cur_moving_method = (cur_moving_method + 1) % 4
            times -= 1
            next_moving_change_value += diff

            if (times == 0):
                times = 2
                diff += 1

        # 이동방식만큼 커서를 움직인다.
        row = row + moving_method[cur_moving_method][0]
        col = col + moving_method[cur_moving_method][1]
    return arr

arr = fill_array(N)
max_len = len(str(max_num))

# print
for i in range(height):
    for j in range(width):
        print('%{0}d'.format(max_len)%(arr[i][j]), end=' ')
    print()

