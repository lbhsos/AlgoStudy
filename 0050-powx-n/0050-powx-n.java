class Solution {
    Map<Integer, Double> dp;
    public double pow(double x, int n, int cnt) {
        if (dp.containsKey(cnt)) {
            return dp.get(cnt);
        }
        if (cnt%2 == 0) {
            dp.put(cnt, pow(x, n, cnt/2) * pow(x, n, cnt/2));
        } else {
            dp.put(cnt,pow(x, n, cnt/2) * pow(x, n, cnt/2) * x);
        }
        
        return dp.get(cnt);
    }
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        if (n < 0) {
            x = 1/x;
            n *= (-1);
        } 

        dp = new HashMap<>();
        dp.put(0, 1.0);
        dp.put(1, x);

        pow(x, n, n);
        return dp.get(n);
    }
}
