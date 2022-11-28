class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int n = nums.length;
        int right = n-1;
        int mid = 0;
        boolean found = false;
        
        if (n == 0) {
            return new int[]{-1,-1};
        }
        
        while (left <= right) {
            mid = (int) (left+right) / 2;
            if (nums[mid] == target) {
                found = true;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        if (!found) {
            return new int[]{-1,-1};
        }
        
        int firstIdx = mid;
        
        while (true) {
            if (firstIdx < 0 || nums[firstIdx] < target) {
                break;
            }
            
            firstIdx -= 1;
        }
        
        int lastIdx = mid;
        while (true) {
            if (lastIdx >= n || nums[lastIdx] > target) {
                break;
            }
       
            lastIdx += 1;
        }
        
        return new int[]{firstIdx+1, lastIdx-1};
    }
}