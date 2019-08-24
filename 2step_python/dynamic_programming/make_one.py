n = int(input())
arr = {1:0,2:1,3:1}

def find_num(num):
    if num == 1:
        return arr[num]
    elif num > 1: 
        if num in arr:
            return arr[num]
        else:
            if num % 6 == 0:
                temp = min(find_num(num//3), find_num(num//2))
            elif num % 3 == 0:
                temp = min(find_num(num//3), find_num(num-1))
            elif num % 2 == 0:
                temp = min(find_num(num//2), find_num(num-1))
            else:
                temp = find_num(num-1)
            arr[num] = temp + 1
            return arr[num]
    
answer = find_num(n)
print(answer)

