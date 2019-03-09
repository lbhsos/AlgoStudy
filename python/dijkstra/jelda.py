import heapq
from pprint import pprint
from collections import defaultdict

class PriorityQueue():
    
    def __init__(self):
        self.pq = []
        self.counter = 0

    def insert(self, priority, value):
        entry = [priority, self.counter, value]
        self.counter += 1
        heapq.heappush(self.pq, entry)

    def pop(self):
        while self.pq:
            priority, counter, value = heapq.heappop(self.pq)
            if value != None:
                return priority, value
        raise KeyError('Pop from an empty PriorityQueue')    
    
def search_least_cost(cave, length, cost, visited):
    current_x = 0
    current_y = 0
    cost[current_y][current_x] = cave[current_y][current_x]
    
    min_neighbor_pq = PriorityQueue()
    
    while True:
        neighbors = []
        if current_x > 0 : # left
            if not visited[current_y][current_x - 1] :
                neighbors.append([current_x - 1, current_y])
        if current_y > 0 : # up
            if not visited[current_y - 1][current_x] :
                neighbors.append([current_x, current_y - 1])
        if current_x < length - 1 : # right
            if not visited[current_y][current_x + 1] :
                neighbors.append([current_x + 1, current_y])
        if current_y < length - 1 : # down
            if not visited[current_y + 1][current_x] :
                neighbors.append([current_x, current_y + 1])
        
        for neighbor in neighbors :
            cost[neighbor[1]][neighbor[0]] = min(cost[neighbor[1]][neighbor[0]],
                                                    cave[neighbor[1]][neighbor[0]] + cost[current_y][current_x])
            min_neighbor_pq.insert(cost[neighbor[1]][neighbor[0]], neighbor)
            # if neighbor[0] is length - 1 and neighbor[1] is length - 1 : return cost[length - 1][length - 1]

        visited[current_y][current_x] = True
        if visited[length - 1][length - 1] : break
        min_neighbor = min_neighbor_pq.pop()
        while visited[min_neighbor[1][1]][min_neighbor[1][0]] : min_neighbor = min_neighbor_pq.pop()
        
        current_x = min_neighbor[1][0]
        current_y = min_neighbor[1][1]

    return cost[length - 1][length - 1]

count = 1

while(True):
    cave_size = int(input(""))
    if cave_size is 0 : break
        
    cave_init = []   
    cost_init = [] 
    visited_init = []
    for i in range(cave_size):
        row = list(map(int, input("").split(' ')))
        row_cost = []
        row_visited = []
        for i in range(cave_size):
            row_cost.append(9999)
            row_visited.append(False)
        cave_init.append(row)
        cost_init.append(row_cost)
        visited_init.append(row_visited)

    print('Problem ' , count, ': ',  search_least_cost(cave_init, cave_size, cost_init, visited_init),sep="")
    count += 1