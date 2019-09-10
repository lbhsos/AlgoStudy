import sys

def get_sum(arr):
    global answer
    for i, num in enumerate(arr):
        if num is True:
            continue
        elif i < (len(arr)-1):
            next_num = arr[i+1]
            answer += (num*next_num)
            arr[i+1] = True
        else:
            answer += num
            
positive, negative = [], []
n = int(input())
answer = 0
for _ in range(n):
    num = int(input())
    if num <= 0: 
        negative.append(num)
    elif num > 1:
        positive.append(num)
    else:
        answer += num        
positive.sort(reverse=True)
negative.sort()

get_sum(negative)
get_sum(positive)
    
print(answer)
