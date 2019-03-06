import heapq

def search_least_cost(cave):
    cost = [[99999999 for col in range(len(cave[0]))] for row in range(len(cave))]
    visited = [[False for col in range(len(cave[0]))] for row in range(len(cave))]
    current_x = 0
    current_y = 0
    cost[current_y][current_x] = cave[current_y][current_x]
    
    min_neighbor_pq = []
    for i in range(len(cave)):
        for j in range(len(cave[0])):
            heapq.heappush(min_neighbor_pq, (cost[j][i], [j,i]))  # ([x,y], cost[y][x])
    
    while True:
       
        neighbors = []
        if current_x > 0 : # left
            neighbors.append([current_x - 1, current_y])
        if current_y > 0 : # up
            neighbors.append([current_x, current_y - 1])
        if current_x < len(cave[0]) - 1 : # right
            neighbors.append([current_x + 1, current_y])
        if current_y < len(cave) - 1 : # down
            neighbors.append([current_x, current_y + 1])
        
        for neighbor in neighbors :
            if not visited[neighbor[1]][neighbor[0]] : 
                cost[neighbor[1]][neighbor[0]] = min(cost[neighbor[1]][neighbor[0]],
                                                     cave[neighbor[1]][neighbor[0]] + cost[current_y][current_x])
                heapq.heappush(min_neighbor_pq, (cost[neighbor[1]][neighbor[0]], neighbor))

        visited[current_y][current_x] = True
        min_neighbor = heapq.heappop(min_neighbor_pq)
        
        current_x = min_neighbor[1][0]
        current_y = min_neighbor[1][1]
        
        if current_x is len(cave[0]) - 1 and current_y is len(cave) - 1 : break
            
    return cost[len(cave)-1][len(cave[0]) - 1]

while(True):
    cave_size = input("")
    if cave_size is 0 : break

    cave = []   
    cost = [] 
    for i in range(cave_size):
        row = map(int, raw_input("").split(' '))
        cave.append(row)

    print(search_least_cost(cave))
