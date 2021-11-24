N, M = list(map(int, input().split(" ")))
arr = list(map(int, input().split(" ")))

arr = sorted(arr)
ret_dict = dict()
def call(i, ret_arr):
    global M
    
    if len(ret_arr) == M:
        ret_dict[tuple(ret_arr)] = 1
        return 
    
    for next_i in range(i+1, N):
        call(next_i, ret_arr + [str(arr[next_i])])

for i in range(N):
    call(i, [str(arr[i])])

for k in ret_dict.keys():
    print(' '.join(k))
