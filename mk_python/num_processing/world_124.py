def solution(n):
    world = [1,2,4]
    three_num = list(map(int, list(str(convert(n, 3)))))
    for i in range(len(three_num)-1 , -1, -1):
        num = three_num[i]
        if num not in world and i is not 0:
            three_num[i - 1] -= 1
            three_num[i] += 3
    result = []
    for num in three_num:
        if num is not 0 : result.append(str(world[num-1]))
    return "".join(result)
    
def convert(n, base):
    T = "0123456789ABCDEF"
    q, r = divmod(n, base)
    if q == 0:
        return T[r]
    else:
        return convert(q, base) + T[r]
