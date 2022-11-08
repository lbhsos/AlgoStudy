import math
import decimal
n = int(input())
scores = list()
for _ in range(n):
    scores.append(decimal.Decimal(input()))

def is_answer(score):
    global answer
    decimal_answer = decimal.Decimal(str(answer))
    if score * decimal_answer % 1 == 0:
        return True

    tmp = score * decimal_answer

    tmp2 = math.trunc(math.ceil(tmp) / decimal_answer * 1000)
    if tmp2 == score * 1000:
        return True
    return False

answer = 0
while True:
    answer += 1
    flag = True
    for score in scores:
        if not is_answer(score):
            flag = False
            break
    if flag:
       break

print(answer)