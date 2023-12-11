class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean inserted = false;

//Edge case. empty intervals, or newInterval comes before. return merged
        if(intervals.length == 0 || newInterval[1] < intervals[0][0]) {
                res.add(newInterval);
                res.addAll(Arrays.asList(intervals));
                return res.toArray(new int[res.size()][2]);
        }

        for(int i=0; i<intervals.length; i++) {
            int[] curr = intervals[i];
            if(newInterval[0] > curr[1]) res.add(curr);
            else if(curr[0] > newInterval[1]) {
                if(!inserted) {
                    res.add(newInterval);
                    inserted = true;
                }
                res.add(curr);
            }
            else {
                newInterval[0] = Math.min(curr[0], newInterval[0]);
                newInterval[1] = Math.max(curr[1], newInterval[1]);
            }
        }
        if(!inserted) res.add(newInterval);

        return res.toArray(new int[res.size()][2]);
    }
}
