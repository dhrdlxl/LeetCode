class Solution {
    public int countPyramids(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] copyGrid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copyGrid[i][j] = grid[m - 1 - i][j]; 
            }
        }

        return findPyramid(grid) + findPyramid(copyGrid);
    }

    private int findPyramid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && grid[i - 1][j] >= 1) {
                    grid[i][j] = Math.min(grid[i - 1][j - 1], grid[i - 1][j + 1]) + 1;
                    count += grid[i][j] - 1;
                }
            }
        }

        return count;
    }
}