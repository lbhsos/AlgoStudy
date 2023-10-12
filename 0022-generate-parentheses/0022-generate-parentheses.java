class Solution:
    def generateParenthesis(self, n: int) -> List[str]:        
        answer = list()
        def appendParenthesis(string, left: int, right: int):
            if right > left or left > n:
                return 
            if len(string) == 2*n:
                answer.append(string)
                return
            
            appendParenthesis(string + "(", left + 1, right)
            appendParenthesis(string + ")", left, right + 1)
        appendParenthesis("", 0, 0)
        return answer

