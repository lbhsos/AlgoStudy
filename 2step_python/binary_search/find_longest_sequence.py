n = int(input())
arr = list(map(int, input().split(" ")))
vector = [0]

## 작은 수를 찾을 때 이분 탐색을 쓴다.

def binary_search(num):
    global vector
    left, right = 0, len(vector)
    while left < right:
        mid = (left + right) // 2
        if vector[mid] < num:
            left = mid + 1
        elif vector[mid] >= num:
            right = mid
    return right
            

    
for num in arr:
    last_num = vector[-1]
    if last_num >= num:
        i = binary_search(num)
        vector[i] = num
    else:
        vector.append(num)
        
print(vector)

