from itertools import combinations
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        answers = list()

        for combi in combinations(nums, 4):
            if sum(combi) == target:
                answers.append(combi)
        return set(answers)
        
