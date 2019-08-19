import pprint
from collections import deque

def solution(m, n, puddles):
    global path
    path = [[0] * m for i in range(n)]
    for water in puddles:
        row = water[1] -1
        col = water[0] -1
        path[row][col] = -1
    answer = dp(n-1,m-1)
    #pprint.pprint(path)
    return answer % 1000000007

def dp(row, col):
    if row == 0 and col == 0:
        return 1
    if row < 0 or col < 0:
        #print(row, col)
        return 0
    if path[row][col] == -1:
        return 0
    if path[row][col] != 0:
        #print("good ", row, col)
        return path[row][col]
    #print(row, col)
    path[row][col] = dp(row-1, col) + dp(row,col-1)
    return path[row][col]

