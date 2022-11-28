class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var left: Int = 0
        val n: Int = nums.size
        var right: Int = n-1
        var mid: Int = 0
        var found: Boolean = false
        
        if (n == 0) {
            return intArrayOf(-1, -1)
        }
        
        while (left <= right) {
            mid = (left+right) / 2 as Int
            if (nums[mid] == target) {
                found = true
                break
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        if (!found) {
            return intArrayOf(-1, -1)
        }
        
        var firstIdx: Int = mid;
        
        while (true) {
            if (firstIdx < 0 || nums[firstIdx] < target) {
                break
            }
            
            firstIdx -= 1
        }
        
        var lastIdx: Int = mid
        while (true) {
            if (lastIdx >= n || nums[lastIdx] > target) {
                break
            }
       
            lastIdx += 1
        }
        return intArrayOf(firstIdx+1, lastIdx-1)
        
    }
}