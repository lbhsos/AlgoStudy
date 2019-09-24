import java.util.Arrays;
class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        //Arrays.sort(A);
        int [] cache = new int [X+2];
        for(int i=0; i<X+2; i++){
            cache[i] = -1;
        }
        for(int i=0; i<A.length; i++){
            int leaf = A[i];
            if (cache[leaf] == -1){
                cache[leaf] = (i);
            }
        }
        int minTime = cache[X];
        
        for(int i=1; i<X+1; i++){
            if (cache[i] == -1){
               return -1;
            }
           if (cache[i] > minTime){
               minTime = cache[i];
           }
        }
        return minTime;
    }
}
