class Solution {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backtrack(row, col, 0, word, board, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(
        int row,
        int col,
        int idx,
        String word,
        char[][] board,
        boolean[][] visited
    ) {
        // Check for invalid or visited
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] == true) {
            return false;
        }
        // Does the character match?
        if (board[row][col] != word.charAt(idx)) {
            return false;
        }
        // Have we matched the entire word?
        if (idx == word.length() - 1) {
            return true;
        }
        visited[row][col] = true;

        // Explore the 4 neighbors
        if (backtrack(row - 1, col, idx + 1, word, board, visited)) return true;
        if (backtrack(row, col + 1, idx + 1, word, board, visited)) return true;
        if (backtrack(row + 1, col, idx + 1, word, board, visited)) return true;
        if (backtrack(row, col - 1, idx + 1, word, board, visited)) return true;

        visited[row][col] = false;
        return false;

    }
}
