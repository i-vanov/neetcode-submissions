class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // Sort the array so that duplicates are adjacent
        Arrays.sort(candidates);
        backtrack(0, target, candidates, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(
        int start,
        int remaining,
        int[] candidates,
        List<Integer> path,
        List<List<Integer>> res) {
            
            // We've found a valid combination
            if (remaining == 0) {
                res.add(new ArrayList<>(path));
                return;
            } else if (remaining < 0) {
                return;
            } else {
                for (int i = start; i < candidates.length; i++) {
                    // Prevent duplicates in a sorted array
                    if (i > start && candidates[i] == candidates[i - 1]) {
                        continue;
                    }
                    path.add(candidates[i]);
                    backtrack(i + 1, remaining - candidates[i], candidates, path, res);
                    path.remove(path.size() - 1);

                }
            }
        }
}
