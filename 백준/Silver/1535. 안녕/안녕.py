from itertools import combinations
n = int(input())
lost_points = list(map(int, input().split(" ")))
gain_points = list(map(int, input().split(" ")))

answer = 0
indexs = [i for i in range(n)]
def is_possible(i):
    global indexs

    max_joy = 0

    for combination in combinations(indexs, i):
        points = 100
        joy = 0
        for idx in combination:
            gain_point, lost_point = gain_points[idx], lost_points[idx]
            if points - lost_point <= 0:
                break
            points -= lost_point
            joy += gain_point
            max_joy = max(max_joy, joy)
    return max_joy

for i in range(n, 0, -1):
    answer = max(answer, is_possible(i))

print(answer)