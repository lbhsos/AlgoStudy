def solution(triangle):
    answer = 0
    row_len= len(triangle)
    arr = [[0] * (i+1) for i in range(row_len)]
    arr[0][0] = triangle[0][0]
    for row in range(1,row_len):
        for col, val in enumerate(triangle[row]):
            if row == col:
                arr[row][col] = arr[row-1][col-1] + val
            elif col-1 >= 0:
                arr[row][col] = max(arr[row-1][col-1], arr[row-1][col]) + val
            else:
                arr[row][col] = arr[row-1][col] + val       
    answer = max(arr[row_len-1])
    return answer
