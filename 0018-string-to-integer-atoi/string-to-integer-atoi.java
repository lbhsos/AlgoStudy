import java.math.BigInteger;
class Solution {
    public int myAtoi(String s) {
        s = s.stripLeading();
        StringBuilder sb = new StringBuilder();
        boolean sign = false;
        
        for (int i=0; i<s.length(); i++) {
            Character tmp = s.charAt(i);
            if (tmp.equals('-') || tmp.equals('+')) {
                if (sign || sb.length() != 0) {
                    break;
                } 
                sign = true;
            } else if (!Character.isDigit(tmp)) {
                break;
            }
            sb.append(tmp);
        }

        String tmpString = sb.toString();
        if (tmpString.length() == 0 || tmpString.equals("+") || tmpString.equals("-")) {
            return 0;
        }
        
        BigInteger minInt = new BigInteger(Integer.toString(Integer.MIN_VALUE));
        BigInteger maxInt = new BigInteger(Integer.toString(Integer.MAX_VALUE));
        BigInteger target = new BigInteger(tmpString);

        if (target.compareTo(minInt) < 0) {
            return Integer.MIN_VALUE;
        } else if (target.compareTo(maxInt) > 0) {
            return Integer.MAX_VALUE;
        } else {
            return Integer.parseInt(tmpString);
        }
    }
}
