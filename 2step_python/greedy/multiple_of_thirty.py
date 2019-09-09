n = input()
num = list(map(int, list(n)))
length = len(n)

if num.count(0) > 0 and sum(num) % 3 == 0:
    num.sort(reverse=True)
    print(''.join(list(map(str, num))))
else:
    print(-1)
    
