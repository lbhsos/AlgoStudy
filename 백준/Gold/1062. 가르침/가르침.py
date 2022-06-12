from itertools import combinations
from string import ascii_lowercase

N, K = list(map(int, input().split(" ")))
alpha = ['a', 'n', 't', 'i', 'c']
alphabet_list = list(ascii_lowercase)
for i in alpha:
    alphabet_list.remove(i)
answer = 0

arr = list()
for i in range(N):
    word = input()
    word = word[4:-4]
    arr.append(word)
    
def check(tuples):
    global arr
    alpha = ['a', 'n', 't', 'i', 'c']

    for i in tuples:
        alpha += [i]
    alpha_dict = dict.fromkeys(alpha)

    count = 0

    for word in arr:
        all_pass = True
        for char in word:
            if char not in alpha_dict:
                all_pass = False
                break
        if all_pass:
            count += 1
    return count

if K < 5:
    answer = 0
else:
    for tuples in list(combinations(alphabet_list, K-len(alpha))):
        answer = max(answer, check(tuples))

print(answer)
