from itertools import combinations
from collections import defaultdict


def solution(orders, course):
    answer = []

    def make_combination(order, num):
        if len(order) < num:
            return
        for combination in combinations(order, num):
            courses[''.join(combination)] += 1

    for num in course:
        courses = defaultdict(int)
        for order in orders:
            sorted_order = sorted(list(order))
            make_combination(sorted_order, num)

        max_value = 0
        for key, value in sorted(courses.items(),key = lambda x:x[1], reverse = True):
            if value >= max_value and value > 1:
                answer.append(key)
                max_value = value




    # print( sorted(answer))
    return sorted(answer)
# solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2,3,5])
# solution(["XYZ", "XWY", "WXA"], [2,3,4]	)