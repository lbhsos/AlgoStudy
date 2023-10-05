class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int left = 0;
        int right = s.length() - 1;

        boolean answer = true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                answer = false;
                break;
            }
            left++;
            right--;
        }
        return answer;
    }
}
