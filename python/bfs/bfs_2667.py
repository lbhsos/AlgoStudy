from queue import Queue
from pprint import pprint

size = int(input(""))
data = [list(map(int, list(input("")))) for _ in range(size)]

def find_free(data_array) : 
    for i in range(size):
        for j in range(size):
            if data_array[i][j] is not 0 : return [i, j]
    return None

count = 0
start = []
results = []
while True :
    start = find_free(data)
    
    if start is None : break

    result = 0    
    q = Queue()
    q.put(start)
    
    while not q.empty():
        item = q.get()
        if data[item[0]][item[1]] is 0 : continue
        data[item[0]][item[1]] = 0 # visited
        result += 1
        
        navers = []
        if item[0] > 0 and data[item[0] - 1][item[1]] is not 0 : navers.append([item[0] - 1, item[1]])
        if item[1] > 0 and data[item[0]][item[1] - 1] is not 0 : navers.append([item[0], item[1] - 1])
        if item[0] < size - 1 and data[item[0] + 1][item[1]] is not 0 : navers.append([item[0] + 1, item[1]])
        if item[1] < size - 1 and data[item[0]][item[1] + 1] is not 0 : navers.append([item[0], item[1] + 1])
        
        for naver in navers : 
            if data[naver[0]][naver[1]] is not 0 : q.put(naver)
    count += 1
    results.append(result)

print(count)
results = sorted(results)
for result in results: print(result)
