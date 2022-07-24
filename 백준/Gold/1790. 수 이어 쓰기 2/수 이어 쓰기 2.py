import sys
import math

n, k = map(int, ' '.join(sys.stdin.readline().split()).split(" "))

_sum = 0
idx = 0
temp = 0
while True:
    temp = 9 * math.pow(10, idx - 1) * idx
    if _sum + temp > k:
        break
    _sum += temp
    idx += 1

div, mod = divmod(k - _sum, idx)
temp = math.pow(10, idx - 1)
num = temp + div 

if mod == 0:
    if num - 1 > n:
        print(-1)
        exit()
    if temp == 1:
        print(k)
        exit()
    print(int((num-1) % 10))
    exit()

if num > n:
    print(-1)
    exit()
count = 1
for i in list(str(int(num))):
    if count == mod:
        print(i)
        break
    count += 1


  
    
  
