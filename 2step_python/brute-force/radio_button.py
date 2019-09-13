from itertools import product


n = int(input())
m = int(input())
num = [i for i in range(10)]
length = len(str(n))
channel = 100
numbers = []
ans = {}

if m:
    button = list(map(int, input().split(" ")))
    for i in button:
        num.remove(i)

## N이 100번 일 경우
if channel == n:
    print(0)
## 모든 버튼이 안 눌릴 경우
elif m == 10:
    print(abs(n-channel))
elif len(num) == 1 and 0 in num:
    print(min(abs(n-channel), n+1))
else:
    count = abs(n-channel)
    
    arr_type_num = product(num, repeat = length)
    numbers += list(map(int, [''.join(list(map(str, item))) for item in arr_type_num]))
    
    if 0 in num:
        num.remove(0)
        min_num = str(min(num))
        numbers.append(int(min_num + '0'*length))
    else: 
        min_num = str(min(num))
        numbers.append(int(min_num * (length+1)))
        
    if length > 1:
        max_num = str(max(num))
        numbers.append(int(max_num * (length-1)))
    
    print(numbers)
    for number in numbers:
        temp = len(str(number)) + abs(n-number)
        if temp < count:
            count = temp
    print(count)
