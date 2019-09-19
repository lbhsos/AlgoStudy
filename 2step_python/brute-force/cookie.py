def solution(cookie):
    answer = -1
    n = len(cookie)
    acc = [0] * n
    sum_l = 0
    for i in range(n):
        acc[i] = sum(cookie[:i+1])

    m, left, right = 0, 0, n-1
    while m+1 < n:
        if left == 0:
            A = acc[m]
        else:
            A = acc[m] - acc[left - 1]
        B = acc[right] - acc[m]
        
        ## adjusting m, left, right based on A, B
        if A == B:
            if answer < A:
                answer = A
            m += 1
            left, right= 0, n-1
        elif A < B:
            right -= 1
        elif A > B:
            left += 1  
        
        ## adjusting m to search next mid point
        if m < left or m == right:
            m += 1
            left, right= 0, n-1
            
    return max(answer, 0)
