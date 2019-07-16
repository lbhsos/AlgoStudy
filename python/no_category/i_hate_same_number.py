def solution(arr):
    last = arr[0]
    answer = [last]
    for item in arr:
        if item != last : 
            answer.append(item)
            last = item
    return answer
