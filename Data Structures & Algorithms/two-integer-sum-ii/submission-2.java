class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            // If the sum equals the target, return 1-indexed indices
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }
            // Move right pointer inward since the sum is bigger
            // than the target and the array is sorted
            if (sum > target) {
                right--;
            }
            // Move left pointer inward since the sum is smaller
            // than the target and the array is sorted
            else {
                left++;
            }
        }
        throw new IllegalStateException("No solution found");
    }
}
