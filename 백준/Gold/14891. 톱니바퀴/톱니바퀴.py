from collections import deque

N, S = '0', '1'
wheels = deque()
for _ in range(4):
    wheels.append(deque(input()))

LEFT, RIGHT = -1, 1

def calculate_score():
    global wheels
    score = 0
    for i in range(4):
        if wheels[i][0] == S:
            score += (2 ** i)
    return score

def check(wheel_no, direction, visited):
    global wheels

    left, right = False, False
    left_no, right_no = wheel_no - 1, wheel_no + 1
    if left_no > -1:
        if int(wheels[wheel_no][6]) + int(wheels[left_no][2]) == 1:
            left = True

    if right_no < 4:
        if int(wheels[right_no][6]) + int(wheels[wheel_no][2]) == 1:
            right = True

    if left and left_no not in visited:
        check(left_no, direction * (-1), visited + [left_no])

    if right and right_no not in visited:
        check(right_no, direction * (-1), visited + [right_no])

    move(wheel_no, direction)

def move(wheel_no, direction):
    if direction == LEFT:
        num = wheels[wheel_no].popleft()
        wheels[wheel_no].append(num)
    else:
        num = wheels[wheel_no].pop()
        wheels[wheel_no].appendleft(num)

for _ in range(int(input())):
    wheel_no, direction = map(int, input().split(" "))
    check(wheel_no - 1, direction, [wheel_no - 1])

print(calculate_score())

