n = int(input())

pairs = dict()
answer = 0

for i in range(n):
    city, state = list(input().split(" "))
    city_code = city[0:2]
    if city_code == state:
        continue
    if (state, city_code) in pairs:
        pairs[(state, city_code)] += 1
    else:
        pairs[(state, city_code)] = 1
    
    pair_count = 0
    if (city_code, state) in pairs:
        pair_count = pairs[(city_code, state)]
    answer += pair_count
    
print(answer)