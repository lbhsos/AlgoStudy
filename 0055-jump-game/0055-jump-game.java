class Solution {
    public boolean canJump(int[] nums, int dest) {
        if (dest == 0) {
            return true;
        } 

        for (int i=0; i<dest; i++) {
            if (nums[i]+i>=dest) {
                return canJump(nums, i);
            }
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        return canJump(nums, n-1);
    }
}
