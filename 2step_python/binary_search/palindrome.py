
def solution(s):
    length = len(s)
    pivot = 0
    answer = -1
    for p_len in range(length,0, -1):
        pivot = 0
        while (pivot + p_len - 1) < length :
            count = 0
            left = pivot 
            right = pivot + p_len - 1
            while True:
                if left >= right:
                    if left == right and s[left] == s[right]: 
                        count+=1
                    answer = count
                    return answer
                if s[left] == s[right]:
                    left +=1
                    right -= 1
                    count += 2
                else:
                    break
            
            pivot += 1
            
    return answer
