from sys import stdin
N = int(input()) # N은 3의 배수
P = list(map(int, input().split(" ")))
S = list(map(int, stdin.readline().split()))
cards = [i%3 for i in range(N)]

# 거꾸로돌아간다.
def shuffle(P):
    global S

    arr =[0] * N
    for i in range(N):
        S_value = S[i]
        arr[S_value] = P[i]
    return arr

answer = 0
origins = P

while P != cards:
    P = shuffle(P)
    if P == origins:
        answer=-1
        break

    answer += 1

print(answer)



