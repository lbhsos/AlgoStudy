class Solution {
  public int[] sortArray(int[] nums) {
    mergeSort(nums, 0, nums.length - 1, nums.length);
    return nums;
  }

  public void mergeSort(int[] nums, int left, int right, int n) {
    if (left != right) {
      int mid = (left + right) / 2;
      mergeSort(nums, left, mid, n);
      mergeSort(nums, mid + 1, right,n);
      merge(nums, left, right, n);
    }
  }

  public void merge(int[] nums, int left, int right, int n) {
    int mid = (left + right) / 2;
    int i = left;
    int j = mid + 1;
    int k = left;
    int[] temp = new int[n];
    while (i <= mid && j <= right) {
      if (nums[i] <= nums[j]) {
        temp[k++] = nums[i++];
      } else if (nums[i] > nums[j]) {
        temp[k++] = nums[j++];
      }
    }
    while(i<=mid) temp[k++] = nums[i++];
    while(j<=right) temp[k++] = nums[j++];
    for (i=left; i<=right; i++) {
      nums[i] = temp[i];
    }
  }
}
