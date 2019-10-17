### import pprint


t = int(input())
for test in range(t):
    answer = 0

    def get_route(i, j, value, count, k_flag): 
        global answer
        positions = [[+1,0], [-1,0],[0,-1],[0,+1]]
        for pos in positions:
            new_i, new_j = i+pos[0], j+pos[1]
            if new_i < n and new_i > -1 and new_j < n and new_j > -1:
                new_val = mountain[new_i][new_j]
                if not visit[new_i][new_j]:
                    if value > new_val:
                        visit[new_i][new_j] = True
                        answer = max(answer, get_route(new_i, new_j, new_val, count+1, k_flag))
                    elif value > (new_val - k) and not k_flag: # 작으면 k 사용
                        visit[new_i][new_j] = True
                        diff = abs(value-new_val)
                        adjust_k = min(k, diff+1)
                        answer = max(answer, get_route(new_i, new_j, new_val-adjust_k, count+1, True))


        visit[i][j] = False # 다음 진입을 위해 돌려주기
        return max(count, answer)


    def get_max_pos(max_num):
        for i in range(n):
            for j in range(n):
                cur = mountain[i][j]
                if cur == max_num:
                    max_info[i,j] = max_num

    def get_max_num():
        ret_max = float('-inf')
        for i in range(n):
            for j in range(n):
                cur = mountain[i][j]
                ret_max = max(cur, ret_max)
        return ret_max

    # GET INPUT
    n, k = list(map(int, input().split(" ")))
    mountain = [[] for _ in range(n)]
    visit = [[False] * n for _ in range(n)]
    max_info = {}
    for i in range(n):
        mountain[i] = list(map(int, input().split(" ")))
    # mountain = [[9, 3, 2, 3, 2],[6, 3, 1, 7, 5],[3, 4, 8, 9, 9],[2, 3, 7, 7, 7],[7, 6, 5, 5, 8]]

    max_num = get_max_num()
    get_max_pos(max_num)


    for key in max_info.keys():
        visit[key[0]][key[1]] = True
        answer = max(answer, get_route(key[0], key[1], max_info[key], 1, False))


    print('#{}'.format(test+1),answer)

        
    

