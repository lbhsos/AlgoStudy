import pprint

def solution(n, arr1, arr2):
    answer = []

    map1 = make_map(n, arr1)
    map2 = make_map(n, arr2)
    
    final_map = get_final_map(map1, map2)
    answer = final_map
    return answer  

def get_final_map(map1, map2):
    n = len(map1)
    temp_map = [[0] * n for i in range(n)]
    ret_map = []
    for row in range(n):
        for col in range(n):
            if map1[row][col] == 1 or map2[row][col] == 1 :
                temp_map[row][col] = "#"
            elif map1[row][col] == 0 and map2[row][col] == 0:
                temp_map[row][col] = " "
        a = ''.join(temp_map[row])
        ret_map.append(a)
    
    return ret_map

def make_map(n,arr):
    temp_map = [[] * n for _ in range(n)] 
    for i in range(n):
        item = arr[i]
        binary_str = bin(item)
        binary_str = binary_str[2:]
        b_len = len(binary_str)
        rest = n - b_len
        for _ in range(rest):
            binary_str = "0" + binary_str
        b_arr = list(map(int,binary_str))
        temp_map[i] = b_arr
    return temp_map
