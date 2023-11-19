class Solution {
    private final int MAX = 1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {
        long[][] dp = new long[2001][1001];
        
        dp[startPos + 500][0] = 1;
        
        for (int step = 1; step <= k; step++) {
            for (int j = 0; j <= 2000; j++) {
                if (j - 1 >= 0 && dp[j - 1][step - 1] > 0) {
                    dp[j][step] = (dp[j][step] + dp[j - 1][step - 1]) % MAX;
                }
                if (j + 1 <= 2000 && dp[j + 1][step - 1] > 0) {
                    dp[j][step] = (dp[j][step] + dp[j + 1][step - 1]) % MAX;
                }
            }
        }
        
        return (int)dp[endPos + 500][k];
    }
}