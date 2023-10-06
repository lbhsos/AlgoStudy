class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> romans = new LinkedHashMap<>();
        romans.put("M", 1000);
        romans.put("CM", 900);
        romans.put("D", 500);
        romans.put("CD", 400);
        romans.put("C", 100);
        romans.put("XC", 90);
        romans.put("L", 50);
        romans.put("XL", 40);
        romans.put("X", 10);
        romans.put("IX", 9);
        romans.put("V", 5);
        romans.put("IV", 4);
        romans.put("I", 1);

        int prev = 0;
        int answer = 0;
        while (prev < s.length()) {
            int cur = prev + 1;
            String romanKey = s.substring(prev, Math.min(cur + 1, s.length()));
            if (romans.containsKey(romanKey)) {
                prev = cur + 1;
                answer += romans.get(romanKey);
                continue;
            }
            
            romanKey = s.substring(prev, cur);
            prev = cur;
            answer += romans.get(romanKey);

        }

        return answer;
    }
}
