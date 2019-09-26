import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int n = A.length;
        int minus = A[0] * A[1] * A[n-1];
        int plus = A[n-1] * A[n-2] * A[n-3];
        
        return Math.max(minus,plus);
    }
}
