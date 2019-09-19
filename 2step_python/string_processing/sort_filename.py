from collections import defaultdict

def solution(files):
    answer = []
    arr = []
    for i, file in enumerate(files):
        data = defaultdict(str)
        file=file.lower()
        head_point, num_point, tail_point = 0,0,0
        num_point, tail_point  = find_num_point(file)
        data['idx'] = i
        data['head'] = file[0:num_point]
        data['number'] = file[num_point:tail_point]
        data['tail'] = file[tail_point:]
        arr.append(data)
    pprint.pprint(arr)
    arr = sorted(arr, key=lambda x:(x['head'], int(x['number']), x['idx']))
    
    for file in arr:
        index = file['idx']
        answer.append(files[index])
    return answer

def find_num_point(file):
    n = len(file)
    num_point, tail_point = -1, -1
    for i in range(n):
        if file[i].isdigit() and num_point == -1:
            num_point = i
        elif file[i].isalpha() and num_point != -1:
            tail_point = i - 1
        if num_point != -1 and tail_point != -1:
            break
            
    # if tail doesn't exist
    if tail_point == -1:
        tail_point = n
    return num_point, tail_point
    
