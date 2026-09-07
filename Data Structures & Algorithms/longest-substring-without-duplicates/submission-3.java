class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int i = 0;
        int j = 1;

        if (s.length() < 2) {
            return s.length();
        } else {
            charSet.add(chars[i]);
            while (j < chars.length) {
                while (charSet.contains(chars[j])) {
                    charSet.remove(chars[i]);
                    i++;
                }
                charSet.add(chars[j]);
                j++;
                maxLength = Math.max(maxLength, j - i);
            }
        }

        return maxLength;
    }
}
