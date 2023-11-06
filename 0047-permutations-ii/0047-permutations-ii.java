class Solution {
    private Set<List<Integer>> answer = new LinkedHashSet<>();

    public void find(int[] nums, List<Integer> permutations, boolean[] visited) {
        if (permutations.size() >= nums.length) {
            if (permutations.size() == nums.length) {
                answer.add(new ArrayList<>(permutations));
            }
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            permutations.add(nums[i]);
            visited[i] = true;
            find(nums, permutations, visited);
            permutations.remove(permutations.size() - 1);
            visited[i] = false;
        }    
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        find(nums, new ArrayList<>(), visited);
        return answer.stream().toList();
    }
}
