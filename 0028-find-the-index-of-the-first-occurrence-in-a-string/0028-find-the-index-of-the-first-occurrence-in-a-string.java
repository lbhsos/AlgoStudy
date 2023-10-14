class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();

        for (int i=0; i<haystack.length()-n+1; i++) {
            String tmp = haystack.substring(i, i+n);
            if (tmp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
