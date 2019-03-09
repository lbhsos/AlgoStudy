import operator
data = [list(input("")) for _ in range(8)]
result = [0 for row in range(8) for column in range(8) if data[row][column] is 'F' and (row+column) % 2 is 0]
print(len(result))