class Solution {
    public boolean stoneGame(int[] piles) {
        int N = piles.length;
        
        int[][] dp = new int[N + 2][N + 2];
        
        for (int k = 1; k <= N; k++) {
            for (int i = 0; i + k <= N; i++) {
                int j = i + k - 1;
                int parity = (i + k + N) % 2;
                
                if (parity == 1) {
                    dp[i + 1][j + 1] = Math.max(piles[i] + dp[i + 2][j + 1], piles[j] + dp[i + 1][j]);
                } else {
                    dp[i + 1][j + 1] = Math.max(-piles[i] + dp[i + 2][j + 1], -piles[j] + dp[i + 1][j]);
                }
            }
        }
        
        return dp[1][N] > 0;
    }
}