class Solution {
    public String convert(String s, int numRows) {
        Map<Integer, ArrayList> zigzag = new LinkedHashMap<>();
        
        int i = 1;
        int UP = 1;
        int DOWN = -1;

        int DIRECTION = DOWN;
        if (numRows == 1) {
            return s;
        }
        
        for (int idx = 0; idx < s.length(); idx++) {
            ArrayList<Character> row = zigzag.getOrDefault(i, new ArrayList<>());
            row.add(s.charAt(idx));
            zigzag.put(i, row);

            if (DIRECTION == UP) {
                i--;
            } else if (DIRECTION == DOWN) {
                i++;
            }

            if (i == numRows + 1 && DIRECTION == DOWN) {
                i = numRows - 1;
                DIRECTION = UP;
            } else if (i == 0 && DIRECTION == UP) {
                i = 2;
                DIRECTION = DOWN;
            }
        }

        String answer = "";
        for (int rowIdx=1; rowIdx <= numRows; rowIdx++) {
            ArrayList<Character> row = zigzag.getOrDefault(rowIdx, new ArrayList<>());
            for (int j=0; j<row.size(); j++) {
                answer += Character.toString(row.get(j));
            }
        }
        
        return answer;

    }
}
