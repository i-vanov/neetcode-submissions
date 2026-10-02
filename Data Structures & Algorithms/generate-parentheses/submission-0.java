class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0, 0, n, new StringBuilder(), res);
        return res;
    }

    private void backtrack(int open, int close, int n, StringBuilder str, List<String> res) {
        if (open == n && close == n) {
            res.add(str.toString());
            return;
        }
        
        // Use only n opening parantheses
        if (open < n) {
            str.append('(');
            backtrack(open + 1, close, n, str, res);
            str.deleteCharAt(str.length() - 1);
        }

        // Add ) if there is an unmatched (
        if (close < open) {
            str.append(')');
            backtrack(open, close + 1, n, str, res);
            str.deleteCharAt(str.length() - 1);
        }
        
    }
}
