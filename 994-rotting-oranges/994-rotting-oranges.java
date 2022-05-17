class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] mask = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mask[i][j] = 0;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) { //rotten orange
                    bfs(grid, mask, i, j);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {// fresh orange
                    if (answer < mask[i][j]) {
                        answer = mask[i][j];
                    } else if (mask[i][j] == 0) {
                        return -1;
                    }
                }
            }
        } 
        
        return answer;
    }
    
    private void bfs(int[][] grid, int[][] mask, int y, int x) {
        Queue<Integer> q = new LinkedList<>();
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        q.offer(y);
        q.offer(x);
        
        while (!q.isEmpty()) {
            int curY = q.poll();
            int curX = q.poll();
            
            for (int direction = 0; direction < 4; direction++) {
                int nextY = curY + move[direction][0];
                int nextX = curX + move[direction][1];
                
                if (nextY >= 0 && nextY < grid.length && nextX >= 0 && nextX < grid[0].length) {
                    if (grid[nextY][nextX] == 1 && 
                       (mask[nextY][nextX] == 0 || mask[nextY][nextX] > mask[curY][curX] + 1)) {
                        mask[nextY][nextX] = mask[curY][curX] + 1;
                        q.offer(nextY);
                        q.offer(nextX);
                    }
                }
            }
        }
        
    }
    
}