from collections import deque

#1. 서비스 영역 면적 구하기
def get_service_area(k):
    length = 2*k - 1
    mask = [[0] * length for _ in range(length)]
    mask[k-1][k-1] = -1
    q = deque()
    q.append([k-1,k-1])
    q.append(None)
    positions = [[0,+1],[0,-1],[+1,0],[-1,0]]
    count = 1 # q의 depth 조사
    mask_size = 1
    while q:
        cur = q.popleft()
        
        if cur == None:
            count += 1
            q.append(None)
            cur = q[0]
            if count == k:
                break
            if cur == None:
                break
            else:
                cur = q.popleft()
                
        cur_i, cur_j = cur[0], cur[1]
        for pos in positions:
            new_i = cur_i + pos[0]
            new_j = cur_j + pos[1]           
            if new_i < length and new_i > -1 and new_j < length and new_j > -1:
                if mask[new_i][new_j] == 0: 
                    mask[new_i][new_j] = -1
                    mask_size += 1
                    q.append([new_i, new_j])
                    
    return mask, mask_size
        
            

#2. 서비스 영역에 해당하는 집(=값) 구하기
def circulate(mask, k_idx):
    mask_len = len(mask)
    ret = float('-inf')
    for i in range(n):
        for j in range(n):
            pivot = k_idx-1
            count = 0
            for map_i in range(-pivot,pivot+1,1):
                for map_j in range(-pivot, pivot+1, 1):
                    new_i, new_j = i+map_i, j+map_j
                    if new_i > -1 and new_i < n and new_j > -1 and new_j < n:
                        if mask[map_i+pivot][map_j+pivot] * town[new_i][new_j] == -1:
                            count += 1
            ret = max(count, ret)
            
    return ret
                        
            
    


#3. 운영비영이 적자면 그만!
def is_benefit(mask_size, home_count):
    benefit = home_count * m - mask_size
    if benefit >= 0:
        return True
    else: 
        return False
    
t = int(input())
for test in range(t):
    n, m = list(map(int, input().split(" ")))
    town = [[] for _ in range(n)]
    for i in range(n):
        town[i] = list(map(int, input().split(" ")))
    k_idx = 1
    home_count = 0
    flag = True
    ans = float('-inf')
    while True:
        mask, mask_size = get_service_area(k_idx)
        home_count = circulate(mask, k_idx)
        flag = is_benefit(mask_size, home_count)
        if flag:
            ans = max(home_count,ans)
        k_idx += 1
        if 2 * k_idx - 1 > n:
            break

    print("#{}".format(test+1),ans)
    
