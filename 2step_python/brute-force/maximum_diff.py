import itertools

n = int(input())
arr = list(map(int, input().split(" ")))

index_list = list(range(n))

orders=list(itertools.permutations(index_list))
# print(orders)
max_num = float('-inf')
for order in orders:
    summ = 0
    for idx in range(n-1):
        summ += abs(arr[order[idx]]-arr[order[idx+1]])
    if summ > max_num:
        max_num = summ
print(max_num)
