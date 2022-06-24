from itertools import combinations
N = int(input())
count = 0
arr = list()
def get_combination(postition):
    global N, count, arr
    nums = ['9','8','7','6','5','4','3','2','1','0']
    for combination in combinations(nums, postition):
        count += 1
        if len(combination) != 0:
            arr.append(int(''.join(combination)))
position = 1
for i in range(11):
    answer = get_combination(i)

arr.sort()
if N >= (2**10-1):
    print(-1)
else:
    print(arr[N])
