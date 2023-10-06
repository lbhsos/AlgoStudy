class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = -101;
        int n = nums.length;
        List<Integer> answers = new ArrayList<Integer>();

        int k = 0;

        for (int num : nums) {
            if (prev != num) {
                prev = num;
                k += 1;
                answers.add(num);
            }    
        }

        int[] tmp = answers.stream().mapToInt(i->i).toArray();
        for (int i=0; i<n; i++) {
            if (i >= k) {
                nums[i] = '_';
                continue;
            }
            nums[i] = tmp[i];
        }

        return k;
    }
}
