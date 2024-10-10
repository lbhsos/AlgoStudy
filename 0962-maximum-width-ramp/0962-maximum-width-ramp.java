import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
   public int maxWidthRamp(int[] nums) {
    int[] dp = new int[nums.length];
    for (int j = nums.length - 1; j >= 0; j--) {
      if (j == nums.length - 1) {
        dp[j] = nums[j];
      } else {
        dp[j] = Math.max(dp[j + 1], nums[j]);
      }
    }
    int left=0, right = 0, max = 0;
    
    while (right < nums.length) {
      while (left < right && nums[left] > dp[right]) {
        left++;
      }
      right++;
      max = Math.max(max, right - left-1);
    }
    return max;
  }
}