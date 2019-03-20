from queue import Queue
from pprint import pprint
from collections import defaultdict

count_dict = defaultdict(list)
numbers = []
visited = {}


def check_num(num):
    for i in range(2, num):
        if num % i is 0: 
            return False
    return True


def initialize():
    for num in range(1000, 10000):
        if check_num(num):
            visited[num] = False


for num in range(1000, 10000):
    
    if check_num(num):
        numbers.append(num)

for num in numbers: 
    orders = [1, 10, 100, 1000]
    for order in orders:
        order_num = (num // order) % 10

        for i in range(-1 * order_num, 10 - order_num):
            if i is 0:
                continue
            if num + order * i in numbers: 
                if num + order * i >= 1000 and num + order * i < 10000: 
                    count_dict[num].append(num + order * i)


def bfs(source, destination):
    initialize()
    # inital setting
    q = Queue()
    q.put(source)
    visited[source] = True

    level = 0
    dummy = -99999
    q.put(dummy)
    # run
    while not q.empty():
        next = q.get()

        if next == dummy:
            q.put(dummy)
            level += 1
            continue

        if next == destination: 
            return level

        for naver in count_dict[next]:
            if not visited[naver]: 
                q.put(naver)
                visited[naver] = True
                
                
T = int(input(""))

for _ in range(T):
    data = list(map(int, input("").split(' ')))
    print(bfs(data[0], data[1]))