class Solution {
    List<List<Integer>> arr = new ArrayList<>();
    public void call(List<Integer> tmp, boolean[] visited, int[] nums) {
        if (tmp.size() == nums.length) {
            arr.add(new ArrayList(tmp));
            return;
        }

         for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                tmp.add(nums[i]);
                visited[i] = true;
                call(tmp, visited, nums);
                tmp.remove(tmp.size()-1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        call(new ArrayList<>(), visited, nums);
        return arr;
    }
}
