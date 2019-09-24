import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
       
        int answer = 1;
        Arrays.sort(A);
        int prev = 0;
        int i = 0;
        
        while (i < A.length){
            int cur = A[i++];
            if (cur < 1) continue;
            
            if (cur == prev || cur == prev + 1){
                answer = cur+1;
                prev = cur;
            }
            else if (cur != (prev + 1)){
                answer = prev+1;
                break;
            }
            
        }
        return Math.max(answer,1);
    }
}
