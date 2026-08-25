class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        int counter = 0;
        int longest = 0;
        for (int n : nums) {
            numbers.add(n);
        }
        for (Integer num : numbers) {
            counter = 1;
            if (numbers.contains(num - 1)) {
                continue;
            }
            while (numbers.contains(num + 1)) {
                num++;
                counter++;
            }
            if (counter > longest) {
                longest = counter;
            }
        }
        return longest;
    }
}
