class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // 3 1 2 4 3
        int n = A.length;
        int [] acc = new int[n];
        int sum = 0;
        for (int i=0; i<n; i++){
            sum += A[i];
            acc[i] = sum;
        }
        int min = 987665432;
        for(int i=0; i<n-1; i++){
            int cur = Math.abs(acc[i] - (acc[n-1] - acc[i]));
            //System.out.println(cur);
            if (cur< min){
                min = cur;
            }
        }
        return min;
    }
}
