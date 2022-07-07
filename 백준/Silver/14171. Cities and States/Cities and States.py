from collections import defaultdict
n = int(input())

pairs = defaultdict(int)
answer = 0

for i in range(n):
    city, state = list(input().split(" "))
    city_code = city[0:2]
    if city_code == state:
        continue
    pairs[(state, city_code)] += 1
    answer += pairs[(city_code, state)]

print(answer)