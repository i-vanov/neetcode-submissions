class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] used = new int[nums.length];
        backtrack(nums, used, new ArrayList<>(), res);
        return res;

    }

    private void backtrack(
        int[] nums,
        int[] used,
        List<Integer> path,
        List<List<Integer>> res
    ) {
        for (int i = 0; i < nums.length; i++) {
            // Skip the element if the subset already contains it
            if (used[i] > 0) {
                continue;
            }
            path.add(nums[i]);
            used[i]++;
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
            }
            // No start because after choosing an element, any unused element can be next
            backtrack(nums, used, path, res);

            // Undo
            path.remove(path.size() - 1);
            used[i]--;
        }
    }
}
