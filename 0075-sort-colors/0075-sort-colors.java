class Solution {
    
    public void sortColors(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!hm.containsKey(num)) {
                hm.put(num, 0);
            }
            hm.put(num, hm.get(num)+1);
        }
        

        int idx = 0;
        for (int i=0; i<3; i++) {
            while (true) {
                int count = hm.getOrDefault(i, 0);
                if (count > 0) {
                    hm.put(i, count - 1);
                } else {
                    break;
                }
                nums[idx] = i;
                idx++;
            }
        }
    }
}
