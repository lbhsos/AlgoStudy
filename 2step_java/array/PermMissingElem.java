import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;
        int answer = 0;
        Arrays.sort(A);
        if (n == 0){
            answer = 1;
        }
        
        else{
            for(int i=0; i<n; i++){
                if (A[i] != (i+1)){
                    answer = (i+1);
                    break;
                }
            }
            if (answer == 0){
                answer = n+1;
            }
        }
        return answer;
    }
}
