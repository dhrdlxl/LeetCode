class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] mask = new int[m][n];
        int startR = 0;
        int startC = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mask[i][j] = -1;
                if (mat[i][j] == 0) {
                    startR = i;
                    startC = j;
                }
            }
        }
        
        bfs(mat, mask, startR, startC);
        
        return mask;
    }
    
    private void bfs(int[][] mat, int[][] mask, int y ,int x) {
        Queue<Integer> q = new LinkedList<>();
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        q.offer(y);
        q.offer(x);
        mask[y][x] = 0;
        
        while (!q.isEmpty()) {
            int curY = q.poll();
            int curX = q.poll();
            
            for (int direction = 0; direction < 4; direction++) {
                int nextY = curY + move[direction][0];
                int nextX = curX + move[direction][1];
                
                if (nextY >= 0 && nextY < mat.length && nextX >= 0 && nextX < mat[0].length) {
                    if (mask[nextY][nextX] == -1 || mask[nextY][nextX] > mask[curY][curX] + 1) {
                        if (mat[nextY][nextX] == 0) {
                            mask[nextY][nextX] = 0;
                        } else if (mat[nextY][nextX] == 1) {
                            mask[nextY][nextX] = mask[curY][curX] + 1;
                        }
                        
                        q.offer(nextY);
                        q.offer(nextX);
                    }
                }
            }
        }
    }
}