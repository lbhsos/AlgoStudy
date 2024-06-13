class Solution {
  public int maxProfit(int[] prices) {
    int max = 0;
    int n = prices.length;
    int[] dp = new int[n];
    if (n < 2) return 0;
    dp[n-1] = 0;
    dp[n-2] = Math.max(0, prices[n-1] - prices[n-2]);
    max = Math.max(max, dp[n-2]);

    for (int i = n-3; i > -1; i--) {
      dp[i] = dp[i+1];
      for (int j = i+1; j < n; j++) {
          dp[i] = Math.max(dp[i], dp[j] + prices[j] - prices[i]);
      }
      max = Math.max(max, dp[i]);
    }
    
    return max;
  }
}