N, L = list(map(int, input().split(" ")))

def get_sum(k):
    k = k-1
    return ((1 + k) * k) // 2

def is_answer(k):
    global N, std
    _sum = get_sum(k)
    if N-_sum < 0:
        return False
    div, mod = divmod((N-_sum), k)
    if mod != 0:
        return False
    
    std = div
    return True

answer = list()
length = 0
std = 0

for k in range(L, 101):
    if is_answer(k):
        length = k
        break

def create_answer(length):
    global std
    for _ in range(length):
        answer.append(str(std))
        std += 1
create_answer(length)

if length == 0:
    answer.append(str(-1))
print(' '.join((answer)))