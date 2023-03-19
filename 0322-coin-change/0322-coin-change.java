class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] > 0) {
                    int before = dp[i - coin];
                    if (dp[i] == 0 || before + 1 < dp[i]) {
                        dp[i] = before + 1;
                    }
                }
            }
        }
        
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}