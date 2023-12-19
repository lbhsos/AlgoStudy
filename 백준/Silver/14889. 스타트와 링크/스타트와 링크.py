import itertools

n = int(input())
powers = list()
for _ in range(n):
    powers.append(list(map(int, input().split(" "))))
min_value = float('inf')
nCr = itertools.combinations(range(n), n//2)

def get_power_from_start(teams, visited):
    power = 0
    for team in teams:
        visited[team] = True
        for other in teams:
            power += powers[team][other]
    return power

def get_power_from_link(visited):
    power = 0
    for i in range(n):
        if visited[i]: continue
        for j in range(n):
            if visited[j]: continue
            power += powers[i][j]
    return power

for combination in list(nCr):
    visited = [False] * n
    start_power = get_power_from_start(combination, visited)
    link_power = get_power_from_link(visited)
    min_value = min(min_value, abs(start_power - link_power))

print(min_value)