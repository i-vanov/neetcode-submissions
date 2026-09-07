class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            map.put(s.charAt(r), r);
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}
