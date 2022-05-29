class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] mask = new int[n][n];
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                mask[row][col] = -1;
                
                if (q.isEmpty() && grid[row][col] == 1) {//start point
                    q.offer(row);
                    q.offer(col);
                    q2.offer(row);
                    q2.offer(col);
                    mask[row][col] = 0;
                }
            }
        }
        
        
        while (!q.isEmpty()) { // find one island(q2)
            int row = q.poll();
            int col = q.poll();
            
            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + move[direction][0];
                int nextCol = col + move[direction][1];
                
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
                    if (mask[nextRow][nextCol] == -1 && grid[nextRow][nextCol] == 1) {
                        mask[nextRow][nextCol] = 0;
                        q.offer(nextRow);
                        q.offer(nextCol);
                        q2.offer(nextRow);
                        q2.offer(nextCol);
                    }
                }
            }
        }
        
        int answer = n * n + 1;
        while (!q2.isEmpty()) {
            int row = q2.poll();
            int col = q2.poll();
            
            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + move[direction][0];
                int nextCol = col + move[direction][1];
                
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
                    if (mask[nextRow][nextCol] == -1 || mask[nextRow][nextCol] > mask[row][col] + 1) {
                        
                        if (grid[nextRow][nextCol] == 0) { // water
                            mask[nextRow][nextCol] = mask[row][col] + 1;
                        } else { //land
                            mask[nextRow][nextCol] = mask[row][col];
                            if (mask[nextRow][nextCol] != 0 && mask[nextRow][nextCol] < answer) {
                                answer = mask[nextRow][nextCol];
                            }
                        }
                        
                        q2.offer(nextRow);
                        q2.offer(nextCol);
                    }
                }
            }
        }
        
        return answer;
    }
}