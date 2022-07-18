class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < nums.length; i++) {
            for (int next = i + 1; next <= i + nums[i] && next < nums.length; next++) {
                dp[next] = Math.min(dp[next], dp[i] + 1);
                
                if (next == nums.length - 1) {
                    return dp[next];
                }
            }
        }
        
        return dp[nums.length - 1];
    }
}