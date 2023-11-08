class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();

        for (int i=0; i<numRows; i++) {
            List<Integer> row = new ArrayList<>();
            if (i == 0) {
                row.add(1);
            } else {
                List<Integer> prev = answer.get(i-1);
                for (int j=0; j<i+1; j++) {
                    if (j==0 || j==i) {
                        row.add(1);
                    } else {
                        row.add(prev.get(j-1)+prev.get(j));
                    }

                }
            }
            answer.add(row);
        }

        return answer;
    }
}
