N, K = map(int, input().split(" "))
i = 0
ans = 0
def get_binary_cnt(num):
    global K
    # print("---")
    cnt = 0
    while True:
        div, mod = divmod(num, 2)
        # print(div, mod)
        if mod == 1:
            cnt +=1

        if div == 0:
            break
        num = div
        # print(num, cnt)
    if cnt <= K:
        return True
    return False

while True:
    if get_binary_cnt(N):
        break
    N += 1
    ans += 1
print(ans)
