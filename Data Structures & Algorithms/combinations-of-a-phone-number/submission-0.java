class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc",
                            "def", "ghi", "jkl", "mno",
                            "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        backtrack(0, digits, letters, new StringBuilder(), res);
        return res;
    }

    private void backtrack(
        int index,
        String digits,
        String[] letters,
        StringBuilder curr,
        List<String> res

    ) {
        // Base case
        if (index == digits.length()) {
            res.add(curr.toString());
            return;
        }

        String possibleLetters = letters[digits.charAt(index) - '0'];

        for (char c : possibleLetters.toCharArray()) {
            curr.append(c);
            backtrack(index + 1, digits, letters, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
