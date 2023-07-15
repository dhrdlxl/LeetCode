class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int r = 1; r < m; r++) {
            grid[r][0] += grid[r - 1][0];
        }
        for (int c = 1; c < n; c++) {
            grid[0][c] += grid[0][c - 1];
        }
        
        for(int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                grid[r][c] += Math.min(grid[r - 1][c], grid[r][c - 1]);
            }
        }
        
        return grid[m - 1][n - 1];
    }
}