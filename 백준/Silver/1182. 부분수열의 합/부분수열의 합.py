from itertools import combinations

N, S = map(int, input().split(" "))
numbers = list(map(int, input().split(" ")))
answer = 0
def get_combination(count):
    global S, answer
    for combination in list(combinations(numbers, count)):
        if sum(combination) == S:
            answer += 1

for i in range(1,N+1):
    get_combination(i)
print(answer)

