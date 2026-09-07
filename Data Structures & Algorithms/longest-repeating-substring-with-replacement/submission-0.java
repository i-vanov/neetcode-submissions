class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int maxLen = 0;
        int l = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            freqMap.put(s.charAt(r), freqMap.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(s.charAt(r)));
            while (r - l + 1 - maxFreq > k) {
                freqMap.put(s.charAt(l), freqMap.get(s.charAt(l)) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
