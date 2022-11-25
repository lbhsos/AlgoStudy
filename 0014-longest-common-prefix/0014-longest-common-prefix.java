class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        String minStr = null;
        
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
                minStr = str;
            } 
        }
        
        int idx = 0;
        
        while (idx < minLength) {
            boolean same = true;
            Character c = null;
            for (String str : strs) {
                c = minStr.charAt(idx);
                if (!c.equals(str.charAt(idx))) {
                    same = false;
                    break;
                }
            }    
            if (!same) {
                break;
            }
            sb.append(c);
            idx += 1;
        }
        
        return sb.toString();
    }
}