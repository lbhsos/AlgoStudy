n = int(input())
square = {1:1, 2:2}

for i in range(3,n+1):
    square[i] = square[i-1] + square[i-2]
print(square[n] % 10007)
