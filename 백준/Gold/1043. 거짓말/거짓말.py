from collections import deque

NOT_VISITED = 0
X = -1
VISITED = 1

N, M = list(map(int, input().split(" ")))

known = deque()
true_arr = list(map(int, input().split(" ")))
for true_known_person in true_arr[1:]:
    known.append(true_known_person)

true_people = true_arr[0]
visited_parties = [NOT_VISITED] * M
visited = [NOT_VISITED] * (N + 1) ## 사람은 1번부터 시작

parties = list()
for i in range(M):
    parties.append(list(map(int, input().split(" "))))


def delete(known_person):
    global parties
    people_set = list()
    for idx, party in enumerate(parties):
        people = party[1:]
        if visited_parties[idx] != X and known_person in people:
            visited_parties[idx] = X
            people_set += people

    return people_set

while len(known):
    known_person = known.popleft()
    people = delete(known_person)
    for person in people:
        if visited[person] != VISITED:
            visited[person] = VISITED
            known.append(person)

count = 0
for party in visited_parties:
    if party != X:
        count += 1
print(count)





