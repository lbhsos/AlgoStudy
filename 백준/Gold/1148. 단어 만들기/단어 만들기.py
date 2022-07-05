def get_input(words, separator):
    words_count = list()
    while True:
        word = input()
        if word == separator:
            break
        words.append(word)
        temp_dict = dict()
        for character in word:
            if character in temp_dict:
                temp_dict[character] += 1
            else:
                temp_dict[character] = 1
        words_count.append(temp_dict)
    return words_count

words = list()
words_count = get_input(words, "-")

puzzles = list()
puzzles_count = get_input(words, "#")

global_count = dict()

def get_make_word_count(puzzle_count):
    global words_count
    all_count = dict()

    for alphabet in puzzle_count.keys():
        all_count[alphabet] = 0

    for word_count in words_count:
        possible = True
        for character in word_count.keys():
            if character not in puzzle_count or puzzle_count[character] < word_count[character]:
                possible = False
                break

        if possible:
            for character in word_count.keys():
                all_count[character] += 1

    return all_count

for puzzle_count in puzzles_count:
    counts = get_make_word_count(puzzle_count)
    sorts = sorted(counts.items(), key = lambda item: (item[1], item[0]))
    # print(sorts)
    min_str = ""
    min_value = 0
    for idx, sort in enumerate(sorts):
        if idx == 0:
            min_str += sort[0]
            min_value = sort[1]
            continue
        if sorts[0][1] != sort[1]:
            break
        min_str += sort[0]

    max_str = ""
    max_value = 0
    for idx, sort in enumerate(sorts[::-1]):
        if idx == 0:
            max_str += sort[0]
            max_value = sort[1]
            continue
        if sorts[-1][1] != sort[1]:
            break
        max_str += sort[0]

    print(min_str, min_value, max_str[::-1], max_value)






