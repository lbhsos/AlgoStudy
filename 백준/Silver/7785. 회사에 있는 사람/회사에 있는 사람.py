n = int(input())

logs = dict()
for _ in range(n):
    name, action = input().split(" ")
    if action == 'enter':
        logs[name] = 1
    elif action == 'leave':
        del logs[name]

sorted_logs = sorted(logs.keys(), reverse=True)
for log in sorted_logs:
    print(log)