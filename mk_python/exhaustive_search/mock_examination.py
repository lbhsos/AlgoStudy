person_1 = [1,2,3,4,5]
person_2 = [2,1,2,3,2,4,2,5]
person_3 = [3,3,1,1,2,2,4,4,5,5]

persons = [person_1, person_2, person_3]
scores = [0, 0, 0]

def solution(answers):
    for i, answer in enumerate(answers):
        for j, person in enumerate(persons) :
            if person[i % len(person)] == answer : scores[j] += 1

    maximum_score = max(scores)
    maximum_scores = []
    for i, score in enumerate(scores):
        if score == maximum_score: 
            maximum_scores.append(i + 1) # 사람 번호는 1부터 시작

    return maximum_scores

