class Solution {
    private final int MAX = 500002;
    public int minSideJumps(int[] obstacles) {
        int[] dp = {1, 0, 1};
        
        for (int obstacle : obstacles) {
            if (obstacle > 0) {
                dp[obstacle - 1] = MAX;
            }
            
            for (int i = 0; i < 3; i++) {
                if (obstacle - 1 != i) {
                    dp[i] = Math.min(dp[i], Math.min(dp[(i + 1) % 3], dp[(i + 2) % 3]) + 1);
                }
            }
        }
        
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}