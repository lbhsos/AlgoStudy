import math
test = int(input())

def get_distance(x1,y1,x2,y2):
    return math.sqrt(pow(x2-x1,2)+pow(y2-y1,2))
def run():
    x1,y1,r1,x2,y2,r2 = list(map(int, input().split(" ")))
    distance = get_distance(x1,y1,x2,y2)
    _sum = r1 + r2
    _sub = abs(r1-r2)
    if x1== x2 and y1 == y2:
      if r1 == r2:
        answer = -1
      else:
        answer = 0
    elif _sub == distance:
        answer = 1
    elif distance < _sub:
        answer = 0
    elif _sum == distance:
        answer = 1
    elif _sum > distance:
        answer = 2
    elif _sum < distance:
        answer = 0
    print(answer)
for _ in range(test):
    run()
