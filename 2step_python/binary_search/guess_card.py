n = int(input())
card = list(map(int, input().split(" ")))
m = int(input())
numbers = list(map(int, input().split(" ")))
card.sort()

def is_in_card(num):
    left = 0
    right = n-1
    while left <= right:
        mid = (left+right)//2
        if num < card[mid]:
            right = mid - 1
        elif num > card[mid]:
            left = mid + 1
        else:
            return 1
    return 0

for idx, number in enumerate(numbers):
    numbers[idx] = is_in_card(number)
print(' '.join(list(map(str, numbers))))
    
