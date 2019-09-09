row, col = list(map(int, input().split(" ")))

if row == 1:
    answer = 1
elif row == 2:
    answer = min(3, (col-1)//2) + 1
else:
    if col >= 7:
        answer = 5+(col-7)
    else:
        if col - 3 >= 1:
            answer = 4
        else:
            answer = col
print(answer)
