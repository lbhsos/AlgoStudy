class Solution:
    def maxArea(self, height: List[int]) -> int:
        left_stack = list()
        right_stack = list()
        left_idx = 0
        right_idx = len(height)-1
        answer = float('-inf')
        while True:
            left = height[left_idx]
            right = height[right_idx]
            
            width = abs(right_idx - left_idx)
            length = min(left, right)
            
            answer = max(answer, width*length)
            
            if left < right:
                left_idx += 1
            else:
                right_idx -= 1
                
            if left_idx == right_idx:
                break
        return answer
            
            
            
            
            
        
            
                