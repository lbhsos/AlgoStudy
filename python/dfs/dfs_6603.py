import itertools


def print_combination(list):
    for comb in itertools.combinations(list, 6):
        print(' '.join(str(e) for e in comb))

while True:
    data = input("")
    if data is '0':
        break
    data = list(map(int, data.split(' ')))
    print_combination(data[1:])
    print("")