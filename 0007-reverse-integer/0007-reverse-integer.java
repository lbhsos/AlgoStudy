class Solution {
    public int reverse(int x) {
        boolean minus = false;
        if (x < 0) {
            x = x * (-1);
            minus = true;
        }
        String intAsText = Integer.toString(x);
        StringBuffer sb = new StringBuffer(intAsText);
        String reversedInt = sb.reverse().toString();
        Integer parsedInteger = null;
        try {
            parsedInteger = Integer.parseInt(reversedInt);
        } catch (NumberFormatException e) {
            return 0;
        } 
        if (minus) {
            return (-1) * parsedInteger;
        }
        return parsedInteger;

    }
}