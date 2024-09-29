class Solution {
    private Integer[][][] dp;
    private int[][] sum;
    private int MOD = 1000000007;
    
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        dp = new Integer[m][n][k];
        sum = new int[m + 1][n + 1];
        
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                int num = pizza[r].charAt(c) == 'A' ? 1 : 0;
                sum[r][c] = sum[r + 1][c] + sum[r][c + 1] - sum[r + 1][c + 1] + num;
            }
        }
        
        return dfs(m, n, k - 1, 0, 0);
    }
    
    private int dfs(int m, int n, int k, int r, int c) {
        if (sum[r][c] == 0) {
            return 0;
        } else if (k == 0) {
            return 1;
        } else if (dp[r][c][k] != null) {
            return dp[r][c][k];
        } 
        
        int answer = 0;
        
        for (int nextR = r + 1; nextR < m; nextR++) {
            if (sum[r][c] > sum[nextR][c]) {
                answer = (answer + dfs(m, n, k - 1, nextR, c)) % MOD;
            }
        }
        for (int nextC = c + 1; nextC < n; nextC++) {
            if (sum[r][c] > sum[r][nextC]) {
                answer = (answer + dfs(m, n, k - 1, r, nextC)) % MOD;
            }
        }
        
        dp[r][c][k] = answer;
        
        return dp[r][c][k];
    }
}