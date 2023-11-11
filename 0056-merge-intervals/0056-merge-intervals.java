import java.util.Stack;

class Solution {

    public int[][] merge(int[][] intervals) {
        // intervals 정렬 
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<List<Integer>> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if (stack.isEmpty()) {
                stack.push(start);
                stack.push(end);
                continue;
            }

            Integer top = stack.peek();
            if (top >= start && top >= end) {
                continue;
            } else if (top >= start) {
                stack.pop();
                stack.push(end);
            } else {
                answer.add(new ArrayList<Integer>(stack));
                stack = new Stack<>();
                stack.push(start);
                stack.push(end);
            }
        }    

        // flush
        if (!stack.isEmpty()) {
            answer.add(new ArrayList<Integer>(stack));
        }
        return answer.stream().map(u -> u.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);    
    }
}
