class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, target, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(
        int start,
        int remaining,
        int[] nums,
        List<Integer> path,
        List<List<Integer>> res) {

        // We've found a valid combination
        if (remaining == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // This branch' combination sum is larger and is invalid
        if (remaining < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i, remaining - nums[i], nums, path, res);
            path.remove(path.size() - 1);

        }
    }
}
