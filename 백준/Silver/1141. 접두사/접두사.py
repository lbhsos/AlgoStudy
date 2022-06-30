N = int(input())
word_dict = dict()
for i in range(N):
    word = input()
    if word not in word_dict:
        word_dict[word] = 1
    else:
        word_dict[word] += 1
answer = len(word_dict)
words = list(word_dict.keys())


def is_pre_word(word, words):
    for text in words:
        idx = text.find(word)
        if idx == 0:
            return True




for idx, word in enumerate(words):
    if is_pre_word(word, words[0:idx]+words[idx+1:]):
        answer -= 1

print(answer)
