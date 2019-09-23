def make_binary(num):
    # 1이 아니면 못받게
    arr = []
    count = float('-inf')
    while num != 0:
        num, mod = num // 2, num % 2
        if mod == 0:
            count += 1
        else:
            arr.append(count)
            count = 0
    max_count = max(max(arr),0)
    return max_count
    
def solution(N):
    num = make_binary(N)
    return num
