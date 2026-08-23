class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int left = 1;
        int right = 1;
        for (int i = 0; i < length; i++) {
            res[i] = left;
            left *= nums[i];
        }
        for (int j = length - 1; j >= 0; j--) {
            res[j] *= right;
            right *= nums[j];
        }
        return res;
    }
}  
