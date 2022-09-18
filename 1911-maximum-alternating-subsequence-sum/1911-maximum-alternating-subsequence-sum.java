class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[100001][2];//[0]: + / [1]: -
        
        for (int i = 1; i <= nums.length; i++) {
            long num = nums[i - 1];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + num);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - num);
        }
        
        return dp[nums.length][0];
    }
}