class Solution {
    public boolean isValid(String s) {
        Map<String, String> map = new HashMap<>();
        
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");
        
        String[] strs = s.split("");
        int n = strs.length;
        
        if (n % 2 != 0) {
            return false;
        }
        
        Stack<String> stack = new Stack<>();
        int idx = 0;
        while (idx < n) {
            String cur = strs[idx];
            if (map.containsKey(cur)) {
                stack.push(cur);
            } else {
                if (stack.empty() || !map.get(stack.pop()).equals(cur)) {
                    return false;
                }
            }
            idx += 1;
        }
        
        if (stack.size() != 0) {
            return false;
        }
        
        return true;
    }
}