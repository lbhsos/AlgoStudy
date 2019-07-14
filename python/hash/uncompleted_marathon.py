def solution(participant, completion):
    participant_dict = dict.fromkeys(participant , 0)
    for name in participant:
        participant_dict[name] += 1
    
    for name in completion:
        participant_dict[name] -= 1
        if participant_dict[name] == 0 :
            participant_dict.pop(name, None)
    
    return list(participant_dict.keys())[0]
