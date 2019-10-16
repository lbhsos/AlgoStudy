import pprint

t = int(input())
for test in range(t):
    rotation = int(input())
    magnet = [[] for _ in range(4)]
    for i in range(4):
        magnet[i] = list(map(int, input().split(" ")))
    def rotate(idx, direction):   
        if idx - 1 >= 0:
            if (visit[idx-1] == False and magnet[idx-1][2] != magnet[idx][6]):
                visit[idx-1] = True
                rotate(idx-1, direction*(-1))

        if idx + 1 < 4:
            if (visit[idx+1] == False and magnet[idx+1][6] != magnet[idx][2]):
                visit[idx+1] = True
                rotate(idx+1, direction*(-1))

        # 반시계 -> 왼쪽
        if direction == -1:
            temp = magnet[idx][0]
            del magnet[idx][0]
            magnet[idx].append(temp)
        # 시계 -> 오른쪽
        else:
            temp = magnet[idx][-1]
            del magnet[idx][-1]
            magnet[idx].insert(0,temp)


    # 입력 받을 때마다 회전 구현
    for count in range(rotation):
        idx, direction = list(map(int, input().split(" ")))
        idx -= 1
        visit = [False] * 4
        visit[idx] = True
        rotate(idx, direction)

    answer = 0
    if magnet[0][0] == 1:
        answer += 1
    if magnet[1][0] == 1:
        answer += 2
    if magnet[2][0] == 1:
        answer += 4
    if magnet[3][0] == 1:
        answer += 8

    print('#{}'.format(test+1),answer)
