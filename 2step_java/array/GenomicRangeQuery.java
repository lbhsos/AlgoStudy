class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int n = S.length();
        int m = P.length;
        int [] A = new int[n+1];
        int [] C = new int[n+1];
        int [] G = new int[n+1];
        
        //A,C,G put temp index 0 
        for(int i=1; i<n+1; i++){
            char curChar = S.charAt(i-1);
            if (curChar == 'A'){
                A[i] = A[i-1] + 1;
                C[i] = C[i-1];
                G[i] = G[i-1];
            }else if (curChar == 'C'){
                A[i] = A[i-1];
                C[i] = C[i-1] + 1;
                G[i] = G[i-1];
            }else if (curChar == 'G'){
                A[i] = A[i-1];
                C[i] = C[i-1];
                G[i] = G[i-1] + 1;
            }else{
                A[i] = A[i-1];
                C[i] = C[i-1];
                G[i] = G[i-1];
            }
        }
        
        int [] ans = new int[m];
        for(int i=0; i<m; i++){
            int start = P[i];
            int end = Q[i];
            // if start == end
            if (A[start] != A[end+1]){
                ans[i] = 1;
            }else if(C[start] != C[end+1]){
                ans[i] = 2;
            }else if(G[start] != G[end+1]){
                ans[i] = 3;
            }else{
                ans[i] = 4;
            }
        }
        return ans;
    }
}
