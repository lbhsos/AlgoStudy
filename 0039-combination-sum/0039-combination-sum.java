class Solution {
    private List<List<Integer>> answers;
    private int[] candidates;
    private int target;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answers = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        
        run(0, 0, new ArrayList<>());
        return answers;
    }
    
    public void run(int idx, int totalSum, List<Integer> arr) {
        if (totalSum == target) {
            answers.add(new ArrayList<Integer>(arr));
        }
        
        if (totalSum >= target) {
            return;
        }
        
        for (int i=idx; i<candidates.length; i++) {
            arr.add(candidates[i]);
            run(i, totalSum + candidates[i], arr);
            arr.remove(arr.size()-1);
        }
    }
}