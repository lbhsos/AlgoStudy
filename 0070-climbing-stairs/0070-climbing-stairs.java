class Solution {
    public int find(int[] dp, int k) {
        if (dp[k] != 0) {
            return dp[k];
        }
        dp[k]= find(dp, k-1) + find(dp, k-2);
        return dp[k];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        find(dp, n);
        return dp[n];
    }
}
