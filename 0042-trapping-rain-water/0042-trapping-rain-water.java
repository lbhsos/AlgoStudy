class Solution {
    public int trap(int[] height) {
        int answer =0;
        int[] tmp = new int[height.length];
        int heighestPoint = 0;
        int prev = 0;
        for (int i=0; i<height.length; i++) {
            if (prev < height[i]) {
                prev = height[i];
                heighestPoint = i;
            }
        }

        prev = 0;
        for (int j=0; j<heighestPoint; j++) {
            if (prev < height[j]) {
                prev = height[j];
                continue;
            }
            answer += (prev - height[j]);
        }

        prev = 0;
        for (int j=height.length-1; j>heighestPoint; j--) {
            if (prev < height[j]) {
                prev = height[j];
                continue;
            }
            answer += (prev - height[j]);
        }

        return answer;
    }
}
