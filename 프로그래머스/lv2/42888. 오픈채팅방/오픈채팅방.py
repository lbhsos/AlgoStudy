from collections import defaultdict
from collections import deque

def solution(record):
    answer = []
    user_names = dict()
    user_actions = defaultdict(list)
    log_queue = deque()

    for log in record:
        logs = log.split(" ")
        action, user_info = logs[0], logs[1]
        if action == "Leave":
            user_actions[user_info] += ["Leave"]
            log_queue.append((user_info, action))
            continue

        uid, nickname = logs[1], logs[2]
        user_names[uid] = nickname
        if action == "Enter":
            user_actions[uid] += [action]
            log_queue.append((uid, action))

    while log_queue:
        uid, action = log_queue.popleft()
        if action == "Enter":
            answer.append(f"{user_names[uid]}님이 들어왔습니다.")
        else:
            answer.append(f"{user_names[uid]}님이 나갔습니다.")

    return answer
