import sys
from collections import defaultdict

limit_number = 15000
sys.setrecursionlimit(limit_number)
T = int(sys.stdin.readline())

def play():
    n, rules_cnt = list(map(int, sys.stdin.readline().split(" ")))
    times = list(map(int, sys.stdin.readline().split(" ")))
    rules = defaultdict(list)
    for rule in range(rules_cnt):
        need_building, destination = map(int, sys.stdin.readline().split(" "))
        rules[destination - 1] += [need_building - 1]
    dest_building = int(sys.stdin.readline()) - 1
    dp = [float('-inf')] * n

    def get_need_time(building):
        if dp[building] != float('-inf'):
            return dp[building]

        if len(rules[building]) == 0:
            return times[building]

        for need_building in rules[building]:
            dp[need_building] = get_need_time(need_building)
            dp[building] = max(dp[building], dp[need_building] + times[building])

        return dp[building]

    print(get_need_time(dest_building))


for i in range(T):
    play()