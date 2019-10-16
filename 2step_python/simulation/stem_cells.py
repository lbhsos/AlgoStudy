import copy

# 1시간 지나기
def pass_an_hour(time):
    for key in plate.keys():
        if origin[key] / 2 == plate[key]: # 활동상태
            breed(key)
        plate[key] -= 1 # 시간 빼기
        
    
# 번식하기
def breed(key):
    i, j = key[0], key[1]
    value = origin[key]
    positions = [[+1,0],[-1,0],[0,+1],[0,-1]] # 상하좌우
    for pos in positions:
        new_i, new_j = i+pos[0], j+pos[1]
        if (new_i, new_j) in plate: # 이미 자리를 차지하고 있는 세포
            continue
        elif (new_i, new_j) in origin: # 번식 중 생겨난 세포는 더 큰 값이 차지
            origin[new_i, new_j] = max(origin[new_i, new_j], value)
        else:
            origin[new_i, new_j] = value
            
def update():
    for key in origin.keys():
        if key not in plate:
            plate[key] = origin[key]

t = int(input())
for test in range(t):
    # INPUT
    row, col, k = list(map(int, input().split(" ")))
    plate = {}
    for i in range(row):
        temp = input().split(" ")
        for j in range(col):
            if temp[j] == '0': 
                continue
            plate[i,j] = int(temp[j])*2

    origin = copy.deepcopy(plate)
    time = 0

    while time < k:
        time += 1
        pass_an_hour(time)
        update()

    count = 0
    for key in plate.keys():
        if plate[key] > 0:
            count+=1
    print('#{}'.format(test+1),count)

    

