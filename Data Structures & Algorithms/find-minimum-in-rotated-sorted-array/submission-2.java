class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length -1;

        // not l <= r because we know the minimum is in the array
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                // m could itself point to the minimum, therefore we don't exclude it
                r = m;
            }
        }
        return nums[l];
    }
}
