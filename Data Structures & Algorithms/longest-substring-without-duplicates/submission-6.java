class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int i = 0;
        int j = 0;

        if (s.length() < 2) {
            return s.length();
        }
        while (j < chars.length) {
            // Shrink the sliding window from the left until the duplicate is gone
            while (charSet.contains(chars[j])) {
                charSet.remove(chars[i]);
                i++;
            }
            charSet.add(chars[j]);
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}
