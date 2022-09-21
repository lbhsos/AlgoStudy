input_num = int(input())
answer = 0
def get_primes(n):
    arr = [True] * (n+1)
    arr[0], arr[1] = False, False
    primes = dict()
    for i in range(2, n+1):
        if arr[i] == True:
            j = 2
            while (i * j) <= n:
                arr[i*j] = False
                j += 1

    idx = 0
    for i in range(0, n+1):
        if arr[i]:
            primes[idx] = i
            idx += 1
    return primes, idx -1

N = 4000000
primes, primes_cnt = get_primes(N)

dp = dict()
for i in range(primes_cnt+1):
    if primes[i] > input_num:
        break
    # origin = primes[i]
    prev = 0
    for j in range(i, primes_cnt+1):
        calculated_num = prev + primes[j]
        if calculated_num == input_num:
            answer += 1
        if calculated_num >= input_num:
            break
        prev = calculated_num

print(answer)
