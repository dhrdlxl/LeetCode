class NumMatrix {
    private int[][] board;

    public NumMatrix(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        board = new int[R + 1][C + 1];
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                board[r + 1][c + 1] = board[r][c + 1] + board[r + 1][c] - board[r][c] + matrix[r][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return board[row2 + 1][col2 + 1] - board[row2 + 1][col1] - board[row1][col2 + 1] + board[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */