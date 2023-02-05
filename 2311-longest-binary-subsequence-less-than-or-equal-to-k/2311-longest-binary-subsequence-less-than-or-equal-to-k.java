class Solution {
    public int longestSubsequence(String s, int k) {
        int maxLength = 0;
        int[] dp = new int[s.length() + 1];
        
        for (int i = 1; i < s.length() + 1; i++) {
            dp[i] = k + 1;
        }
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int num = s.charAt(i) - '0';
            int shift = 0;
            
            for (int j = maxLength + 1; j > 0; j--) {
                shift = (j - 1 < 31 ? j - 1 : 30);
                
                if (dp[j - 1] + (num << shift) < dp[j]) {
                    if (j == maxLength + 1) {
                        maxLength++;
                    }
                    dp[j] = dp[j - 1] + (num << shift);
                }
            }
        }
        
        return maxLength;
    }
}