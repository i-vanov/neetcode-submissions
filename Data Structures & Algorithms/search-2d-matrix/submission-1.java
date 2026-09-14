class Solution {
    // This sorted matrix with sorted rows is essentially a 1D array
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;
        int r = rows * cols - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            // Map the index back to the matrix, e.g.
            // index 4
            // 4 / 4 -> row 1
            // 4 % 4 -> col 0
            // matrix[1][0] = 10
            int row = m / cols;
            int col = m % cols;

            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
