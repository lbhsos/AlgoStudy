class Solution {
    public int[] solution(int N, int[] A) {
        int [] counters = new int [N]; 
        int max = 0;
        int lastMax = 0;
        for(int i=0; i<A.length; i++){
            int num = A[i];
            if (num == N+1){
                lastMax = max;
                continue;
            }
            if (counters[num-1] < lastMax)
                counters[num-1] = lastMax;
            
            counters[num-1] += 1;
                
            if (counters[num-1] > max){
                max = counters[num-1];
            }
        }
        
        if (lastMax != 0){
            for(int i=0; i<N; i++){
                if (counters[i] < lastMax)
                    counters[i] = lastMax;
            }
        }
        return counters;
    }
}
