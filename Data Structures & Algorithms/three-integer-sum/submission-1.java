class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array so we can reduce the problem to sorted 2Sum
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // Fix an element nums[i] and use two pointers, so that
        // nums[left] + nums[right] = -nums[i]
        // Since we have two pointers after i, we can use length - 2
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate fixed values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            // Use two pointers technique for 2Sum
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // Skip duplicate left values to avoid generating the same triplet again
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // Skip duplicate right values to avoid generating the same triplet again
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum > -nums[i]) {
                    right--;
                } else  {
                    left++;
                }
            }
        }
        return res;
    }
}
