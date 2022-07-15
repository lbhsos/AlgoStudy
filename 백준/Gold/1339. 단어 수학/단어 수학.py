from collections import defaultdict
import math

n = int(input())
scores = defaultdict(int)

def calculate(word):
    global scores

    length = len(word)
    for i, alphabet in enumerate(word):
        scores[alphabet] += int(math.pow(10, length - i - 1))

for i in range(n):
    word = list(input())
    calculate(word)

scores = sorted(scores.items(), reverse=True, key=lambda item:item[1])
num = 9
answer = 0
for alphabet, value in scores:
    answer += (num * value)
    num -= 1
print(answer)
