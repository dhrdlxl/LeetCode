class Solution {
    private boolean[][] mask;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int findMaxFish(int[][] grid) {
        int answer = 0;
        
        int r = grid.length;
        int c = grid[0].length;
        
        mask = new boolean[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mask[i][j] == false && grid[i][j] > 0) {
                    int fishCount = bfs(grid, i ,j);
                    answer = Math.max(answer, fishCount);
                }
            }
        }
        
        return answer;
    }
    
    private int bfs(int[][] grid, int r, int c) {
        int fishCount = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(r);
        q.add(c);
        mask[r][c] = true;
        
        while (!q.isEmpty()) {
            int curR = q.remove();
            int curC = q.remove();
            fishCount += grid[curR][curC];
            
            
            for (int[] direction : directions) {
                int nextR = curR + direction[0];
                int nextC = curC + direction[1];
                
                if (nextR < 0 || nextC < 0 || 
                    nextR >= grid.length || nextC >= grid[0].length) {
                    continue;
                }
                
                if (mask[nextR][nextC] == false && grid[nextR][nextC] > 0) {
                    q.add(nextR);
                    q.add(nextC);
                    mask[nextR][nextC] = true;
                }
            }
        }
        
        return fishCount;
    }
}