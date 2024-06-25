class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n- 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < n && dp[i + j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i + j] + 1);
                }
            }
        }

    return dp[0];
}
}
