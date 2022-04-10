class Solution {
    private int[][] board;
    private int[][] move = {{-1, 0}, {-1, -1}, {0, -1}};
    
    public int maximalSquare(char[][] matrix) {
        int answer = 0;
        board = new int[matrix.length + 1][matrix[0].length + 1]; 
        
        for (int row = 0; row < matrix.length + 1; row++) {
            for (int col = 0; col < matrix[0].length + 1; col++) {
                board[row][col] = 0;
            }
        }
        
        //(sqrt(min) + 1)의 제곱
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    int boardRow = row + 1;
                    int boardCol = col + 1;
                    
                    int minNum = (int)Math.sqrt(getMin(boardRow, boardCol)); // 위, 왼쪽 위, 왼쪽 수 중 가장 작은 수의 제곱근
                    
                    board[boardRow][boardCol] = (minNum + 1) * (minNum + 1);
                    
                    if (answer < board[boardRow][boardCol]) {
                        answer = board[boardRow][boardCol];
                    }
                }
            }
        }
        
        return answer;
    }
    
    private int getMin(int row, int col) {
        int min = 300 * 300 + 1;
        
        for (int i = 0; i < 3; i++) {
            int newRow = row + move[i][0];
            int newCol = col + move[i][1];
            
            if (min > board[newRow][newCol]) {
                min = board[newRow][newCol];
            }
        }
        
        return min;
    }
}