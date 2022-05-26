class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 3];
        int answer = 0;
        for (int i = 3; i < nums.length + 3; i++) {
            dp[i] = max(dp[i -2], dp[i -3]) + nums[i - 3];
            
            answer = max(answer, dp[i]);
        }
        
        return answer;
    }
    
    private int max(int a, int b) {
        return a > b ? a : b;
    }
}