class Solution {
    private boolean[][] mask;
    private int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        mask = new boolean[m][n];
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == word.charAt(0)) {
                    mask[row][col] = true;
                    boolean answer = dfs(row, col, 1, board, word);
                    mask[row][col] = false;
                    
                    if (answer == true) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(int row, int col, int step, char[][] board, String word) {
        if (step == word.length()) {
            return true;
        }
        
        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row + move[direction][0];
            int nextCol = col + move[direction][1];
            
            if (nextRow >= 0 && nextCol >= 0 && nextRow < board.length && nextCol < board[0].length) {
                if (board[nextRow][nextCol] == word.charAt(step)
                   && mask[nextRow][nextCol] == false) {
                    mask[nextRow][nextCol] = true;
                    if (dfs(nextRow, nextCol, step + 1, board, word) == true) {
                        return true;
                    }
                    mask[nextRow][nextCol] = false;
                }
            }
        }
        
        return false;
    }
}