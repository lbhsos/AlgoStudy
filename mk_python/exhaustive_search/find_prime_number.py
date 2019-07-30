from itertools import permutations 

def convert(list): 
    res = int("".join(map(str, list))) 
    return res

def check(num):
    for i in range(2, num):
        if num % i == 0 : return False
    return num not in [0, 1]

def solution(numbers):
    answer = 0
    re_ordered_papers = set()
    for i in range(1,len(numbers) + 1):
        re_ordered_papers = re_ordered_papers | set([convert(papers) for papers in set(permutations(numbers, i))])

    for re_ordered_paper in re_ordered_papers:        
        if check(re_ordered_paper) :
            answer += 1

    return answer
