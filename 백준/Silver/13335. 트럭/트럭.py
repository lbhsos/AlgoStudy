from collections import deque

n, w, L = map(int, input().split(" "))
weights = list(map(int, input().split(" ")))

bridge = deque()
current_bridge_weight = 0
truck_no = 0
time = 1

while truck_no < n:
    next_truck = weights[truck_no]
    if current_bridge_weight + next_truck <= L and len(bridge) < w:
        bridge.append((next_truck, time))
        time += 1
        current_bridge_weight += next_truck
        truck_no += 1
        continue
    left_truck, input_time = bridge.popleft()
    current_bridge_weight -= left_truck
    time = max(input_time + w, time)

if len(bridge) != 0:
    left_truck, input_time = bridge[-1]
    time = input_time + w
print(time)




