class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix[0].length -1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (top <= bottom) {
            int row = top + (bottom - top) / 2;
            if (target > matrix[row][len]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bottom = row - 1;
            } else {
                int l = 0;
                int r = len;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if (target == matrix[row][m]) {
                        return true;
                    } else if (target > matrix[row][m]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
