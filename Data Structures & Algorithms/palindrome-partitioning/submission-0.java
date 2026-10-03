class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(
        String s,
        int startIdx,
        List<String> current,
        List<List<String>> res
    ) {
        if (startIdx == s.length()) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int end = startIdx; end < s.length(); end++) {
            String substring = s.substring(startIdx, end + 1);
            
            if (isPalindrome(substring)) {
                current.add(substring);
                backtrack(s, end + 1, current, res);
                current.remove(current.size() - 1);
            }

        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) { 
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
