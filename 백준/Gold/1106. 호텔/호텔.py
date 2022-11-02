import sys
c, n = list(map(int, sys.stdin.readline().split(" ")))
cities = list()
min_person = float('inf')
for _ in range(n):
    cost, person = list(map(int, sys.stdin.readline().split(" ")))
    min_person = min(person, min_person)
    cities.append((cost, person))

## 정렬순서: 돈의 최솟값, 사람 최대
## cost, person
cities.sort(key=lambda x:(x[1]/x[0]))
min_cost = [float('inf')] * (c+100)
min_cost[0] = 0
for cost, person in cities:
    for i in range(person, c+100):
        min_cost[i] = min(min_cost[i-person]+cost, min_cost[i])
print(min(min_cost[c:]))