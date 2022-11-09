class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answers = new int[2];
        for (int i = 0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    answers[0] = i;
                    answers[1] = j;
                    break;
                }
            }
        }
        
        return answers;
    }
}