class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        int longest = 0;

        for (int num : nums) {
            numbers.add(num);
        }

        for (int num : numbers) {
            if (!numbers.contains(num - 1)) {
                int next = num + 1;
                while (numbers.contains(next)) {
                    next++;
                }
                longest = Math.max(longest, next - num);
            }
        }
        return longest;
    }
}
