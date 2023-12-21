
def binary(left, right, target):
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return left
n = int(input())
arr = list()
arr.append(float('-inf'))
sequences = list(map(int, input().split(" ")))


for num in sequences:
    left = 0
    right = len(arr) - 1
    if num > arr[-1]:
        arr.append(num)
    else:
        idx = binary(left, right, num)
        arr[idx] = num

print(len(arr) - 1)
