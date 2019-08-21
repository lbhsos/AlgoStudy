def solution(dartResult):
    answer = 0
    stack = []
    total_score = 0
    before = 0

    flag_for_digit = 0
    for idx, item in enumerate(dartResult):
        if item.isdigit(): 
            flag_for_digit += 1
            if(flag_for_digit == 2):
                stack.pop()
                stack.append(10)
                flag_for_digit = 0
            else:
                stack.append(int(item))
            continue
        else:
            if item == 'S':
                alpha_dart(1,stack)
            elif item == "D":
                alpha_dart(2,stack)
            elif item == "T":
                alpha_dart(3,stack)
            elif item == "#":
                hashtag_dart(stack)
            elif item == "*":
                star_dart(idx,stack)
            flag_for_digit = 0

    answer = get_answer(stack)
        
    return answer

def get_answer(stack):
    total_score = 0
    while len(stack) != 0:
        score = stack.pop()
        total_score += score
    
    return total_score

def alpha_dart(num,stack):
    score = stack.pop()
    score = pow(score,num)
    stack.append(score)

def hashtag_dart(stack):
    top = stack.pop()
    top = top * (-1)
    stack.append(top)

def star_dart(idx,stack):
    if idx > 2:
        length = 2
    else:
        length = 1
    while length > 0:
        score = stack.pop()
        score = score * 2
        stack.insert(0, score)
        length -= 1

    

