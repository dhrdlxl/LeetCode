class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][] cur = new double[n][n];
        int[] dr = new int[]{2, 2, 1, 1, -2, -2, -1, -1};
        int[] dc = new int[]{1, -1, 2, -2, 1, -1, 2, -2};
        
        cur[row][column] = 1;
        
        for (; k > 0; k--) {
            double[][] before = new double[n][n];
            
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    for (int dir = 0; dir < 8; dir++) {
                        int beforeR = r + dr[dir];
                        int beforeC = c + dc[dir];
                        
                        if (0 <= beforeR && 0 <= beforeC && beforeR < n && beforeC < n) {
                            before[beforeR][beforeC] += cur[r][c] / 8.0;
                        }
                    }
                }
            }
            
            cur = before;
        }
        
        double answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                answer += cur[r][c];
            }
        }
        
        return answer;
    }
}