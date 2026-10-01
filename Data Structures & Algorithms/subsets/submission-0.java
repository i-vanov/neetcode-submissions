// Backtracking: choose -> explore -> undo

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(
        int start,
        int[] nums,
        List<Integer> path,
        List<List<Integer>> res) {
            // Every current path is a valid subset
            res.add(new ArrayList<>(path));

            for (int i = start; i < nums.length; i++) {
                // Take nums[i]
                path.add(nums[i]);

                // Continue with elements after nums[i]
                backtrack(i + 1, nums, path, res);

                // Undo: remove nums[i]
                path.remove(path.size() - 1);
            }
        }
}
