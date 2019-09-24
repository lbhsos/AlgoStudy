class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // 오른쪽 shift
        int length = A.length;
        int [] ret = new int[length];
        for(int i=0; i<length; i++){
            int pos = (i+K) % length;
            ret[pos] = A[i];
        }
        return ret;
    }
}
