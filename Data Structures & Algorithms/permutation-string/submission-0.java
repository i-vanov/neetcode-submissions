class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        int l = 0;
        for (char c : s1.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (int r = 0; r < s2.length(); r++) {
            windowMap.put(s2.charAt(r), windowMap.getOrDefault(s2.charAt(r), 0) + 1);

            if (r - l + 1 > s1.length()) {
                windowMap.put(s2.charAt(l), windowMap.get(s2.charAt(l)) - 1);
                if (windowMap.get(s2.charAt(l)) == 0) {
                    windowMap.remove(s2.charAt(l));
                }
                l++;
            }
            if (r - l + 1 == s1.length()) {
                if (freqMap.equals(windowMap)) {
                    return true;
                }
            }
        }
        return false;
    }
}
