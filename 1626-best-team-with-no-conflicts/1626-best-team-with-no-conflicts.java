class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int answer = 0;
        int n = scores.length;
        int[][] playerScore = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            playerScore[i][0] = ages[i];
            playerScore[i][1] = scores[i];
        }
        
        Arrays.sort(playerScore, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = playerScore[i][1];
            for (int j = 0; j < i; j++) {
                if (playerScore[j][1] <= playerScore[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + playerScore[i][1]);
                }
            }
            
            answer = Math.max(answer, dp[i]);
        }
        
        return answer;
    }
}