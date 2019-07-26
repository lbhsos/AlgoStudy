class Solution {
    static long [] arr;
    public long solution(int N) {
        long answer = 0;
        arr = new long [80];
        calculateArray();
        answer = getAnswer(N);
        return answer;
    }
    public long getAnswer(int n){
        long n1 = arr[n-3];
        long n2 = arr[n-2];
        long n3 = arr[n-1];
        long ans = (n1+2*n2)*2 + n3*2;
        return ans;
    }
    public void calculateArray(){
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2; i<80; i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
    }
    
   
}

