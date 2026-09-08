class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // Build a frequency map for characters in t
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        // How many chars currently meet the required count
        int have = 0;
        // How many distinct chars we need to match
        int need = countT.size();
        // Store the best window
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            // Add the char to the window
            window.put(c, window.getOrDefault(c, 0) + 1);
            // If the window has enough of this char, increment have
            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }
            // While the window is still valid
            while (have == need) {
                // Update the best result if the current window is smaller
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                // Decrease the count of s[l] in window 
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                // If its count in window falls bellow countT, decrement have (stop shrinking from left)
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                // Move l right
                l++;
            }
        }
        // Return the substring if found; otherwise ""
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
