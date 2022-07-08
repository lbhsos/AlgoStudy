def solution(new_id):
    answer = ''
    pre = None
    id = list()
    for idx, character in enumerate(new_id):
        if pre != None and pre == "." and character == ".":
            pre = character
            continue
        if character != "-" and character != "_" and character != "." and not character.isalpha() and not character.isdigit():
            continue
        if (len(id) == 0) and character == ".":
            continue
        if len(id) >= 15:
            continue
        if character.isupper():
            character = character.lower()

        id.append(character)
        pre = character
    
    if len(id) == 0:
        id = ["a"]
    last_character = id[-1]
    if last_character == ".":
        last_character = id[-2]
        id = id[:-1]

    if len(id) <= 2:
        while len(id) < 3:
            id.append(last_character)
    answer = ''.join(id)
    return answer
