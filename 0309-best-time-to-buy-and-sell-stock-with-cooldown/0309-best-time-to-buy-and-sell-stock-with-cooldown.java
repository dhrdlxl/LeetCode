class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            
            for (int j = i - 1; j >= 0; j--) {
                int prevProfit = 0;
                
                if (j - 2 >= 0) {
                    prevProfit = dp[j - 2];
                }
                
                if (prices[i] - prices[j] > 0) {
                    dp[i] = Math.max(dp[i], prevProfit + prices[i] - prices[j]);
                }
            }
        }
        
        return dp[n - 1];
    }
}