import copy
import pprint

t = int(input())
for test in range(t):
    D, W, K = list(map(int, input().split(" ")))
    A, B = 0, 1
    origin_cells = [[] for _ in range(D)]
    for i in range(D):
        origin_cells[i] = list(map(int, input().split(" ")))
    cells = copy.deepcopy(origin_cells)
    
    # 약품 투여해보기
    def put_drug():
        global cells
        global prev_choice
        
        for i in range(D):
            drug_type = choice[i]
            prev_type = prev_choice[i]
            if drug_type != prev_type and drug_type != 2: # 이전 값과 다르고 약물 투여라면 
                for j in range(W):
                    cells[i][j] = drug_type 
            elif drug_type != prev_type and drug_type == 2: # 이전 값과 다르고 약물 투여를 하지 않았다면 원래 값으로 
                cells[i] = copy.deepcopy(origin_cells[i])
        prev_choice = copy.deepcopy(choice)
    
        return

    # K 시험 통과하는지 확인
    def check_pass():
        global cells
        put_drug()
        flag = False
        for j in range(W): # 세로 하나씩 
            prev_cell = cells[0][j]
            count = 1
            flag = False
            for i in range(1,D):
                cur_cell = cells[i][j]
                if cur_cell == prev_cell:
                    count += 1
                else:
                    count = 1
                    prev_cell = cur_cell

                if count >= K:
                    flag = True
                    break

            if flag:
                continue
            else:
                flag = False
                break # 실패

        return flag


    # 완전 탐색
    answer = float('inf')
    choice = [2] * D # 행이 어떤 drug_type을 저장하는지
    prev_choice = [2] * D

    def dfs(row_idx, drug_count, drug_type):
        global answer
        
        if answer == 0: # 최솟값
            return
        
        choice[row_idx] = drug_type
        if row_idx == D - 1:
            if drug_count < answer: # 작을 때만 실행
                flag = check_pass()
                if flag:
                    answer = min(drug_count, answer)
            return

        for next_type in range(2,-1,-1):
            if next_type != 2:
                dfs(row_idx+1, drug_count + 1, next_type)
            else:
                dfs(row_idx+1, drug_count, next_type)
            
    for drug_type in range(2,-1,-1): # X -> B -> A
        if drug_type != 2: 
            dfs(0, 1, drug_type)
        else:
            dfs(0, 0, drug_type)
    print("#{}".format(test+1), answer)

