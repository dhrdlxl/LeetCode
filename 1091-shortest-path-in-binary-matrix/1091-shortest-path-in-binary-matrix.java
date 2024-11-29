class Solution {
    private int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, 
                            {0, -1}, {0, 1}, 
                            {1, -1}, {1, 0}, {1, 1}};
    private int[][] mask;
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        
        Queue<Integer> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        mask = new int[n][m];
        
        q.add(0);
        q.add(0);
        mask[0][0] = 1;
        
        while (!q.isEmpty()) {
            int curR = q.remove();
            int curC = q.remove();
            
            for (int[] direction : directions) {
                int nextR = curR + direction[0];
                int nextC = curC + direction[1];
                
                if (check(n, m, nextR, nextC)
                    && grid[nextR][nextC] == 0
                    && mask[nextR][nextC] == 0) {
                    mask[nextR][nextC] = mask[curR][curC] + 1;
                    q.add(nextR);
                    q.add(nextC);
                }
            }
        }
        
        return mask[n - 1][m - 1] == 0 ? -1 : mask[n - 1][m - 1];
    }
    
    private boolean check(int n, int m, int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= m) {
            return false;
        }
        
        return true;
    }
}