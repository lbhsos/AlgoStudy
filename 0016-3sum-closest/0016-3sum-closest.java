class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int answer = Integer.MAX_VALUE;
        Set<List<Integer>> resultSet = new HashSet();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j < nums.length - 1; j++) {
                int value = target - nums[i] - nums[j]; 
                int tmp = binarySearch(nums, j+1, nums.length, value);
                int tmpSum = tmp + nums[i] + nums[j];
                // System.out.println("tmp:"+tmp+" tmpSum: "+tmpSum);
                if (Math.abs(tmpSum-target) < Math.abs(answer-target)) {
                    answer = tmpSum;
                }
            }
        }
        return answer;
    }
    
    public int binarySearch(int[] nums, int left, int right, int value) {
        int mid = 0;
        
        while (left < right) {
            mid = (int) (left+right) / 2;
            if (nums[mid] == value) {
                return nums[mid];
            }
            else if (nums[mid] > value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[mid];
    } 

}