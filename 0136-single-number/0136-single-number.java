class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                hm.put(nums[i], 1);
            }
        }

        int answer = 0;
        for (Integer key : hm.keySet()) {
            int count = hm.get(key);
            if (count == 1) {
                answer = key;
            }
        }
        return answer;
    }
}
