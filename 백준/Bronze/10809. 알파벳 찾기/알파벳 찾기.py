import string
d = dict.fromkeys(string.ascii_lowercase, -1)
word = input()

for idx, c in enumerate(word):
    if d[c] == -1:
        d[c] = idx

[print(value, end=' ') for value in d.values()]