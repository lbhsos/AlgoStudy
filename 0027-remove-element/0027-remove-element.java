class Solution {
    public int removeElement(int[] nums, int val) {
        List<Integer> answers = new ArrayList<Integer>();
        int k = 0;

        for (int num : nums) {
            if (num != val) {
                k += 1;
                answers.add(num);
            }
        }

        int[] tmp = answers.stream().mapToInt(i->i).toArray();
        for (int i=0; i<nums.length; i++) {
            if (i >= k) {
                nums[i] = '_';
                continue;
            }
            nums[i] = tmp[i];
        }

        return k;
    }
}
