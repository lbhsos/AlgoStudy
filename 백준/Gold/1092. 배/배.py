n = int(input())
weights = list(map(int, input().split(" ")))
m = int(input())
box_weights = list(map(int, input().split(" ")))
box_moved = [False] * m
weights.sort()
box_weights.sort()
pointer = n - 1
box_pointer = m - 1
answer = 0

if weights[-1] < box_weights[-1]:
    answer = -1
    print(answer)
    exit()

def done(box_moved):
    for box_move in box_moved:
        if box_move == False:
            return False
    return True

def get_next_box(box_moved):
    m = len(box_moved)
    for i in range(m - 1, -1, -1):
        if not box_moved[i]:
            return i
    return len(box_moved) - 1
while True:

    if done(box_moved):
        break
    # print(box_moved)
    # print(pointer, box_pointer)
    if pointer == -1 or box_pointer == -1:
        answer += 1
        pointer = n - 1
        box_pointer = get_next_box(box_moved)

    if box_moved[box_pointer]:
        box_pointer -= 1
        continue

    if weights[pointer] >= box_weights[box_pointer]:
        # if not box_moved[box_pointer]:
        box_moved[box_pointer] = True
        pointer -= 1
    box_pointer -= 1


if pointer != n - 1:
    answer += 1

print(answer)






