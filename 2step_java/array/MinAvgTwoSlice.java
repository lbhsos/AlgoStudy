class Solution {
    public int solution(int[] A) {
        int n = A.length;
        int minIdx = 0;
        double minAvg = (A[0]+A[1])/(double)2;
        for(int i=2; i<n; i++){
            double twoAvg = (A[i-1] + A[i])/(double)2;
            if(twoAvg < minAvg){
                minAvg = twoAvg;
                minIdx = i-1;
            }
            
            double threeAvg =(A[i-2] + A[i-1] + A[i])/(double)3;
            if (threeAvg < minAvg){
                minAvg = threeAvg;
                minIdx = i-2;
            }
        }
        return minIdx;
    }
}
