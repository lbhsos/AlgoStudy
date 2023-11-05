class Solution {
    private Set<List<Integer>> answer = new LinkedHashSet<>();

    public void find(int[] candidates, int target, int currentSum, List<Integer> route, int prev) {
        if (currentSum == target) {
            answer.add(new ArrayList<>(route));
            return;
        }

        for (int i=prev+1; i<candidates.length; i++) {
            if (currentSum + candidates[i] > target) {
                return;
            }

            if (i > prev+1 && candidates[i] == candidates[i-1]) {
                continue;
            }
            route.add(candidates[i]);
            find(candidates, target, currentSum + candidates[i], route, i); 
            route.remove(route.size()-1);
        }
    }
    

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        find(candidates, target, 0, new ArrayList<>(), -1);
        return answer.stream().toList();
    }
}
