import math
def solution(n):
    answer = 0
    num_arr = [0,0]
    num_arr += list(range(2,n+1))
    # print(num_arr)
        
    for idx, num in enumerate(num_arr):
        if num_arr[idx] == 0: continue
        else:
            for j in range(2*num, n+1, num):
                num_arr[j] = 0
    
    for num in num_arr:
        if num != 0:
            answer += 1
                
    return answer
