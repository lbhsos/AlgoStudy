class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;

        for (int i=0; i<nums1.length; i++) {
            if (j >= n) {
                break;
            }
            if (nums1[i] >= nums2[j]) {
                for (int k=nums1.length-2; k>=i; k--) {
                    nums1[k+1] = nums1[k];
                }
                nums1[i] = nums2[j++];
            }
        }
        
        int len = nums1.length;

        int idx = m+j;
        for (int i=j; i<n; i++) {
            nums1[idx] = nums2[i];
            idx++;
        }
    }
}
