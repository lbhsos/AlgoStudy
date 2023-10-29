class Solution {
    public boolean isPalindrome(String s) {
        boolean answer = true;
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
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
