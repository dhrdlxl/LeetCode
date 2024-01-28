class Solution {
    public int longestIdealString(String s, int k) {
        int answer = 0;
        int[] dp = new int['z' - 'a' + 1];
        
        for (int i = 0; i < s.length(); i++) {
            int maxNum = 0;
            char alphabet = s.charAt(i);
            
            int start = Math.max(0, alphabet - 'a' - k);
            int end = Math.min('z' - 'a', alphabet - 'a' + k);
            
            for (int j = start; j <= end; j++) {
                maxNum = Math.max(maxNum, dp[j]);
            }
            
            dp[alphabet - 'a'] = maxNum + 1;
            answer = Math.max(answer, maxNum + 1);
        }
        
        return answer;
    }
}