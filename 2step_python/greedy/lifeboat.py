def solution(people, limit):
    answer = 0
    people.sort()
    count = 0
    left = 0
    right = len(people) - 1
    
    while left < right:
        if people[left] + people[right] <= limit:
            count+=1
            left += 1
            right -= 1
        else:
            right -= 1
    answer = len(people) - count
    return answer
