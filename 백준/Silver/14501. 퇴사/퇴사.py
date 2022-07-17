D_DAY = int(input())

days = [0]
prices = [0]
for _ in range(D_DAY):
    day, price = list(map(int, input().split(" ")))
    days.append(day)
    prices.append(price)

dp = [0] * (D_DAY + 1)

def find_max(today):
    working_day = days[today]
    price = prices[today]
    final_day = today+working_day-1
    # 일을 마치는날짜가 더 큰 경우 -> 일을 할 수 없음.
    if final_day > D_DAY:
        dp[today] = dp[min(today+1, D_DAY)]
    else:
        # final_day + 1이 더 큰 경우
        if final_day+1 > D_DAY:
            # print(today, final_day)
            dp[today] = max(price, dp[min(today + 1, D_DAY)])
        else:
            dp[today] = max(price + dp[final_day+1], dp[today+1])

for day in range(D_DAY, 0, -1):
    find_max(day)

print(dp[1])
