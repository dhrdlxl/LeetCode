class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        for (int index = 1; index <= word1.length(); index++) {
            dp[index][0] = index;
        }
        
        for (int index = 1; index <= word2.length(); index++) {
            dp[0][index] = index;
        }
        
        for (int row = 1; row <= word1.length(); row++) {
            for (int col = 1; col <= word2.length(); col++) {
                if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    dp[row][col] = minNum(minNum(dp[row][col - 1], dp[row - 1][col]), dp[row - 1][col - 1]) + 1;
                }
            }
        }
        
        return dp[word1.length()][word2.length()];
    }
    
    private int minNum(int a, int b) {
        return a < b ? a : b;
    }
}