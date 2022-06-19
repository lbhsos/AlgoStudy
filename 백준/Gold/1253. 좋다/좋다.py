N = int(input())
A = list(map(int, input().split(" ")))

A.sort()

def is_good(goal_num, arr):
    left, right = 0, len(arr) - 1

    while left < right:
        sum = arr[left]+arr[right]
        if sum == goal_num:
            return True
        if sum > goal_num:
            right -= 1
        elif sum < goal_num:
            left += 1
    return False

answer = 0
for i, num in enumerate(A):
    tmp_arr = A[0:i] + A[i+1:]
    if is_good(num, tmp_arr):
        answer += 1
print(answer)
