class Solution {
    private int[] sum;
    private int[][][] dp;
    
    public int stoneGameVII(int[] stones) {
        sum = new int[stones.length + 1];
        dp = new int[stones.length][stones.length][2];
        
        for (int i = 0; i < stones.length; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        
        return solution(0, stones.length - 1, 0);
    }
    
    private int solution(int left, int right, int player) {
        if (left == right) {
            return 0;
        } else if (dp[left][right][player] != 0) {
            return dp[left][right][player];
        }
        
        if (player == 0) {
            int first = solution(left + 1, right, 1 - player) + (sum[right + 1] - sum[left + 1]);
            int second = solution(left, right - 1, 1 - player) + (sum[right] - sum[left]);
            
            return dp[left][right][player] = Math.max(first, second);
        } else {
            int first = solution(left + 1, right, 1 - player) - (sum[right + 1] - sum[left + 1]);
            int second = solution(left, right - 1, 1 - player) - (sum[right] - sum[left]);
            
            return dp[left][right][player] = Math.min(first, second);
        }
        
    }
}