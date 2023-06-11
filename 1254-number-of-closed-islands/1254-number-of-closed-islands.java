class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int closedIsland(int[][] grid) {
        int answer = 0;
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    answer += dfs(grid, r, c);
                }
            }
        }
        
        return answer;
    }
    
    private int dfs(int[][] grid, int r, int c) {
        int answer = 1;
        grid[r][c] = 1;
        
        for (int[] direction : directions) {
            int nextR = r + direction[0];
            int nextC = c + direction[1];
            
            if (nextR < 0 || nextR >= grid.length || nextC < 0 || nextC >= grid[0].length) {
                answer = 0;
            } else {
                if (grid[nextR][nextC] == 0) {
                    answer &= dfs(grid, nextR, nextC);
                }
            }
        }
        
        return answer;
    }
}