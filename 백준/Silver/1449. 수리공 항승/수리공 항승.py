n, tape_size = list(map(int, input().split(" ")))
empty_points = list(map(int, input().split(" ")))

empty_points.sort()
# print(empty_points)
answer = 0
_sum = 0
for i, point in enumerate(empty_points):
    if i == 0:
        prev = point
        continue

    interval = point - prev
    prev = point
    # print(interval, _sum)
    if _sum + interval >= tape_size:
        _sum = 0
        answer += 1
        continue
    _sum += interval

print(answer+1)