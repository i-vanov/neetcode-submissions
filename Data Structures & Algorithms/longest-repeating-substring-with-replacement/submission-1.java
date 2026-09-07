class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int maxLen = 0;
        int l = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            // Update the char frequency
            freqMap.put(s.charAt(r), freqMap.getOrDefault(s.charAt(r), 0) + 1);
            // Update the max frequency encountered sofar
            maxFreq = Math.max(maxFreq, freqMap.get(s.charAt(r)));
            // Window length - most frequent char count = number of replacements needed
            while (r - l + 1 - maxFreq > k) {
                // Shrink the window from the left if it is invalid
                freqMap.put(s.charAt(l), freqMap.get(s.charAt(l)) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
