import itertools

class Chicken(object):
    def __init__(self, position):
        self.position = position
        self.chicken_distances = []

    def append_chicken_distance(self, house_distance):
        self.chicken_distances.append(house_distance)

def find_minimum_distance(M, chickens, houses):
    house_size = len(houses)
    answer = 99999999
    for min_chickens in itertools.combinations([chicken.chicken_distances for chicken in chickens], M):
        min_sum = [999999999] * house_size
        for chicken in min_chickens:
            for i in range(house_size) :
                min_sum[i] = min(min_sum[i], chicken[i])
        answer = min(answer, sum(min_sum))
    return answer

N, M = list(map(int, input("").split(' ')))
houses = []
chickens = []
chicken_objects = []

for i in range(N):
    row = list(map(int, input("").split(' ')))
    for j in range(N) :
        if row[j] is 1 :
            houses.append([i, j])
        if row[j] is 2 :
            chickens.append([i,j])

for chicken_index, chicken in enumerate(chickens) : 
    chicken_objects.append(Chicken(chicken))
    for house in houses :
        chicken_objects[chicken_index].append_chicken_distance(abs(house[0] - chicken[0]) + abs(house[1] - chicken[1]))

print(find_minimum_distance(M, chicken_objects, houses))