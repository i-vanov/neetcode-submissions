class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        // Use nested loops because matrices can have disconnected
        // components, unlike binary trees. 
        // There is no single starting point like root

        // Find every component and explore it completely with dfs
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    dfs(row, col, grid);
                }
            }
        }
        return count;
    }
    // Explore one component completely
    private void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length || 
            col < 0 || col >= grid[0].length || 
            grid[row][col] != '1') {
                return;
        }
        // Mark the cell as visited
        grid[row][col] = '2';

        // Explore the 4 neighbours
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row + 1, col, grid);
        dfs(row, col - 1, grid);
    }
}
