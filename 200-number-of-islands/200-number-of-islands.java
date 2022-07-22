class Solution {
    private int[][] mask;
    private int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        mask = new int[grid.length][grid[0].length];
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1' && mask[row][col] == 0) {
                    answer++;
                    mask[row][col] = answer;
                    
                    //bfs
                    q.offer(row);
                    q.offer(col);
                    
                    while (!q.isEmpty()) {
                        int curRow = q.poll();
                        int curCol = q.poll();
                        
                        for (int direction = 0; direction < 4; direction++) {
                            int nextRow = curRow + move[direction][0];
                            int nextCol = curCol + move[direction][1];
                            
                            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length
                               && grid[nextRow][nextCol] == '1' && mask[nextRow][nextCol] == 0) {
                                mask[nextRow][nextCol] = answer; 
                                q.offer(nextRow);
                                q.offer(nextCol);
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}