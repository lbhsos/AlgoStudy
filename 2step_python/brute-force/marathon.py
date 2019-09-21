def solution(participant, completion):
    answer = ''
    completion.sort()
    participant.sort()
    completion.append(None)
    for p, c in zip(participant, completion):
        if p != c:
            answer = p
            break
    # answer = participant[len(completion)]
    return answer
