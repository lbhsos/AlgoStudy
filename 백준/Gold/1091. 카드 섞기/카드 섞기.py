N = int(input()) # N은 3의 배수
cards = [0] * N
P = list(map(int, input().split(" "))) # 0 1 2 중 하나,
S = list(map(int, input().split(" ")))

def init():
    cards_info = dict()
    for i in range(N):
        cards_info[i] = (i, i%3)
    return cards_info

def shuffle(cards_info):
    global S

    for origin_idx, card_info in cards_info.items():
        current_idx, current_host = card_info[0], card_info[1]
        new_idx, new_host = S[current_idx], S[current_idx]%3
        cards_info[origin_idx] = (new_idx, new_host)
    return cards_info

def match(cards_info):
    global P
    for origin_idx, card_info in cards_info.items():
        current_idx, current_host = card_info[0], card_info[1]
        if P[origin_idx] != current_host:
            return False
    return True


cards_info = init()
answer = 0

while True:
    if match(cards_info):
        break
    if answer > 1000000:
        answer = -1
        break
    new_cards = shuffle(cards_info)
    cards_info = new_cards
    answer += 1

print(answer)



