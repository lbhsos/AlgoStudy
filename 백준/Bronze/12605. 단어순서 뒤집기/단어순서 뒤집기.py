n = int(input())

def reverse(words):
    length = len(words) - 1
    for i in range(length, -1, -1):
        if (i == 0):
            print(words[i])
        else:
            print(words[i], end=' ')


for i in range(n):
    print("Case #{}:".format(i+1), end=' ')
    reverse(input().split(" "))