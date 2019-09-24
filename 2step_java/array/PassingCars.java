import java.util.HashMap;

class Solution {
    public int solution(int[] A) {
        long count = 0;
        int n = A.length;
        long sum = 0;
        for(int i=n-1; i>=0; i--){
            if (A[i] == 1){
                count++;
            }else if(A[i] == 0){
                sum += count;
            }
        }
        // System.out.println(sum);
        if (sum > 1000000000){
            sum = -1;
        }
        return (int)sum;
        
    }
}
