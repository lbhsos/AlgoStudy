import sys
limit_number = 15000
sys.setrecursionlimit(limit_number)

n, m = list(map(int, sys.stdin.readline().split(" ")))
visited = [False] * n
links = dict()
for i in range(n):
    links[i] = list()

for i in range(m):
    num1, num2 = map(int, sys.stdin.readline().split(" "))
    num1, num2 = num1 -1, num2 -1
    links[num1] += [num2]
    links[num2] += [num1]

answer = 0

def visit(num):
    global visited, links

    for neighbor in links[num]:
        # print(neighbor)
        if not visited[neighbor]:
            visited[neighbor]= True
            visit(neighbor)


for num, neighbors in links.items():
    if not visited[num]:
        visited[num] = True
        visit(num)

        answer += 1

print(answer)