class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] board = new int[m + 1][n + 1];
        int[][] answer = new int[m][n];
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                board[row + 1][col + 1] = mat[row][col] + board[row + 1][col] + board[row][col + 1] - board[row][col];
            }
        }
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int minRow = Math.max(0, row - k);
                int minCol = Math.max(0, col - k);
                int maxRow = Math.min(m, row + k + 1);
                int maxCol = Math.min(n, col + k + 1);
                
                answer[row][col] = board[maxRow][maxCol] - board[maxRow][minCol] - board[minRow][maxCol] + board[minRow][minCol];
            }
        }
        
        return answer;
    }
}