class Solution {
    private int M;
    private int N;
    private boolean[][] mask;
    private final boolean O = true;
    private final boolean X = false;
    
    private final int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public void solve(char[][] board) {
        M = board.length;
        N = board[0].length;
        mask = new boolean[M][N];
        
        if (M == 1 || N == 1) //다 가장자리에 있어서 안바뀜
            return;
        
        // 1. 가장 외곽의 O와 연결된 부분 찾아서 mask에 true로 표시
        // 첫번째 열, 마지막 열
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col += (N - 1)) {
                if (board[row][col] == 'O' && mask[row][col] == false) {
                    mask[row][col] = O;
                    dfs(board, row, col);
                }
            }
        }
        
        // 첫번째 행, 마지막 행
        for (int row = 0; row < M; row += (M - 1)) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] == 'O' && mask[row][col] == false) {
                    mask[row][col] = O;
                    dfs(board, row, col);
                }
            }
        }
        
        // 2. mask에서 O인 부분만 O, 나머지 부분은 X
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] == 'O' && mask[row][col] == X) { // 가장 외곽 O와 연결이 안된 곳
                    board[row][col] = 'X';
                }
            }
        }
        
        return;
    }
    
    private void dfs(char[][] board, int row, int col) {
        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row + move[direction][0];
            int nextCol = col + move[direction][1];
            
            if (nextRow >= 0 && nextCol >= 0 && nextRow < M && nextCol < N) {
                if (board[nextRow][nextCol] == 'O' && mask[nextRow][nextCol] == false) {
                    mask[nextRow][nextCol] = O;
                    dfs(board, nextRow, nextCol);
                }
            }
        }
        
        return;
    }
}