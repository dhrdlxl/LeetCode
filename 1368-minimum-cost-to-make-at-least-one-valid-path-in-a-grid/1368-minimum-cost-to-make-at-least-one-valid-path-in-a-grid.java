class Solution {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] dp;
    private final int MAX = Integer.MAX_VALUE;
    private Queue<Integer> q;
    
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        q = new LinkedList<>();
        dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = MAX;
            }
        }
        
        dfs(0, 0, 0, grid);
        
        int cost = 0;
        while (!q.isEmpty()) {
            cost++;
            
            for (int count = q.size(); count > 0; count -= 2) {
                int r = q.poll();
                int c = q.poll();
                
                for (int dir = 0; dir < 4; dir++) {
                    dfs(r + direction[dir][0], c + direction[dir][1], cost, grid);
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    private void dfs(int r, int c, int cost, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (r < 0 || c < 0 || r >= m || c >= n || dp[r][c] != MAX) {
            return;
        }
        
        dp[r][c] = cost;
        q.offer(r);
        q.offer(c);
        int nextDir = grid[r][c] - 1;
        
        dfs(r + direction[nextDir][0], c + direction[nextDir][1], cost, grid);
    }
}