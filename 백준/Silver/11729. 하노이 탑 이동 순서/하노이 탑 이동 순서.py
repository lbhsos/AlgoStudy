N = int(input())

count = 0
answer = list()
def move(start, to):
    global count, answer
    count += 1
    answer.append("{} {}".format(start, to))

def hanoi(num, start, to, via):
    if num == 1:
        move(start, to)
    else:
        hanoi(num - 1, start, via, to)
        move(start, to)
        hanoi(num - 1, via, to, start)

hanoi(N, 1, 3, 2)

print(count)
for i in range(count):
    print(answer[i])


