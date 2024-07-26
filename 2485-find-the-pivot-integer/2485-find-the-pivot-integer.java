class Solution {

  int[] dp;

  public int pivotInteger(int n) {
// 1+.. +x = x+x+1+...n
    dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1] + i;
    }

    for (int i = 1; i <= n; i++) {
      if (sum(1, i) == sum(i, n)) {
        return i;
      }

    }
    return -1;
  }

  public int sum(int start, int end) {
    return dp[end] - dp[start - 1];
  }
}
