class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                
                if (i == 0 && j == 0) {
                    continue;
                } 
                if (i != 0) {
                    sum += dp[i - 1][j];
                } 
                if (j != 0) {
                    sum += dp[i][j - 1];
                }
                
                dp[i][j] = sum;
            }
        }
            
        return dp[m - 1][n - 1];
    }
}