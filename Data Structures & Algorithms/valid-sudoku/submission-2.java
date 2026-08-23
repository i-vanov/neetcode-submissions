class Solution {
    public boolean isValidSudoku(char[][] board) {
        // rows[r][d] = Have I seen digit d in row r?
        boolean[][] rows = new boolean[9][9];
        // cols[c][d] = Have I seen digit d in col c?
        boolean[][] cols = new boolean[9][9];
        // boxes[b][d] = Have I seen digit d in box b?
        boolean[][] boxes = new boolean[9][9];
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }

                // Convert 1-9 to 0-8
                int digit = board[r][c] - '1';
                // Calculate the box index 0-8
                int box = (r / 3) * 3 + (c / 3);

                if (rows[r][digit] || cols[c][digit] || boxes[box][digit]) {
                    return false;
                }
                
                rows[r][digit] = true;
                cols[c][digit] = true;
                boxes[box][digit] = true;
            }
        }
        return true;
    }
}
