class Solution {

    public boolean isHappy(int n) {
        Map<Integer, Boolean> map = new HashMap<>();
        
        while(true) {
            String s = Integer.toString(n);
            map.put(n, Boolean.TRUE);    
            int sum = 0;
            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                int cur = Character.getNumericValue(c);
                sum += Math.pow(cur, 2);
            }

            if (sum == 1) {
                return true;
            }

            if (map.containsKey(sum)) {
                return false;
            }

            n = sum;
        }

            
    }
}
