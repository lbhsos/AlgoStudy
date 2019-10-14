from collections import defaultdict
num_dict = defaultdict(int)
num_arr = []

def char_to_int(c):
    num = 0
    try:
        num = int(c)
    except ValueError:
        if c == 'A':
            num = 10
        elif c == 'B':
            num = 11
        elif c == 'C':
            num = 12
        elif c == 'D':
            num = 13
        elif c == 'E':
            num = 14
        elif c == 'F':
            num = 15
    return num
    
def make_decimal():
    for key_str in num_dict.keys():
        length = len(key_str) - 1
        decimal = 0
        for i in range(length+1):
            cur = char_to_int(key_str[i])
            decimal += ((cur)*pow(16,length-i))
        num_arr.append(decimal)

def append_last_to_first(n_str):
    n_list = list(n_str)
    last = n_list[-1]
    del n_list[-1]
    n_list.insert(0,last)
    return ''.join(n_list)

def rotate(n_str):
    rotation_str = append_last_to_first(n_str)
    add_num(rotation_str)
    return rotation_str
    
    
def add_num(n_str):
    n = len(n_str)
    length = n // 4
    nums = [n_str[i:i+length] for i in range(0, n, length)]
    for num in nums:
        if num_dict[num] == 0:
            num_dict[num] = 1
    

test = int(input())
for t in range(test):
    num_dict = defaultdict(int)
    num_arr = []
    n, k = list(map(int, input().split(" ")))
    # 4개씩 끊어서 map에 넣기
    n_str = input()
    length = n // 4
    for _ in range(length):
        n_str = rotate(n_str)
    make_decimal()
    num_arr = sorted(num_arr, reverse=True)
    print("#{0}".format(t+1),num_arr[k-1])

