class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int count = getArea(grid, row, col);
                    if (answer < count) {
                        answer = count;
                    }
                }
            }
        }
        
        return answer;
    }
    
    private int getArea(int[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
            grid[row][col] = 0;
            return 1 + getArea(grid, row + 1, col) + getArea(grid, row - 1, col)
                + getArea(grid, row, col + 1) + getArea(grid, row, col - 1);
        }
        
        return 0;
    }
}