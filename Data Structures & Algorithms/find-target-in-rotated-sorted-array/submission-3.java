class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) return m;
            // Left half is sorted
            if (nums[l] <= nums[m]) {
                // Is the target in the left half?
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                // If not, then it must be in the right half
                } else {
                    l = m + 1;
                }
            // Right half is sorted
            } else {
                // Is the target in the right half?
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                // If not, then it must be in the left half
                } else {
                    r = m - 1;
                }
            } 
        }
        return -1;
    }
}
