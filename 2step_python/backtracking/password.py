L, C = list(map(int, input().split(" ")))

chars = input().split(" ")

sort_chars = sorted(chars)
print(sort_chars)
vowels = {'a':1, 'o':1, 'i': 1, 'e':1, 'u':1}

## 최소 한 개의 모음과 최소 두 개의 자음
def concat_string(string, idx, vowel_cnt, con_cnt):
    global L, C, sort_chars, vowels
    if len(string) == L and vowel_cnt > 0 and con_cnt > 1:
        print(string)
        return

    for i in range(idx+1, C):
        if sort_chars[i] in vowels:
            concat_string(string+sort_chars[i], i, vowel_cnt + 1, con_cnt)
        else:
            concat_string(string+sort_chars[i], i, vowel_cnt, con_cnt+1)


## 오름차순으로 만들어야함.
cnt = 0
for idx, char in enumerate(sort_chars):
    if char in vowels:
        concat_string(char, idx, 1, 0)
    else:
        concat_string(char, idx, 0, 1)

