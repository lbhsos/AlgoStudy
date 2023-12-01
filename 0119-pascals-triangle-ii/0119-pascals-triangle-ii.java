class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> first = new ArrayList<>();
        first.add(1);
        list.add(first);

        for (int i=1; i<=rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                List<Integer> prev = list.get(i-1);
                int num = 0;
                if (j-1 < 0) {
                    num = prev.get(j);
                } else if (j == i) {
                    num = prev.get(j-1);
                } else {
                    num = prev.get(j-1) + prev.get(j);
                }
                row.add(num);
            }
            list.add(row);
        }
        return list.get(rowIndex);
    }
}
