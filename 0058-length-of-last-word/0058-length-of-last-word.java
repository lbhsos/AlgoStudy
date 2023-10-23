class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        int tmp = 0;
        s += " ";
        for (int i=0; i<s.length(); i++) {
            char a = s.charAt(i);
            if (a == ' ') {
                if (tmp != 0) {
                    ans = tmp;
                    tmp = 0;
                }
                continue;
            }
            tmp += 1;
        }
        return ans;
    }
}
