class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], true);
        }     

        int answer = 1;
        while (true) {
            if (!map.containsKey(answer)) {
                return answer;
            }
            answer += 1;
        }
    }
}
