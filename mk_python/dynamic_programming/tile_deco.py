items = [None for _ in range(100)]
    
def fib(n):
    if items[n] is not None : return items[n]
    if n is 0: return 1
    if n is 1: return 1
    items[n] = fib(n-1) + fib(n-2)
    return items[n]

def solution(N):
    answer = 2*(fib(N-1) + fib(N-2) + fib(N-2) + fib(N-3))
    return answer
