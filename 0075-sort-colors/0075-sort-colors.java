public class Solution {
  public void quickSort(int[] nums, int start, int end) {
    if (start >= end) {
      return;
    }

    int pivot = start;
    int left = start + 1;
    int right = end;
    int temp;

    while (left <= right) {
      while (left <= end && nums[left] <= nums[pivot]) {
        left++;
      }
      while (right > start && nums[right] >= nums[pivot]) {
        right--;
      }

      if (left > right) {
        temp = nums[right];
        nums[right] = nums[pivot];
        nums[pivot] = temp;
      } else {
        temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
      }

      quickSort(nums, start, right - 1);
      quickSort(nums, right + 1, end);
    }
  }
  public void sortColors(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }
}