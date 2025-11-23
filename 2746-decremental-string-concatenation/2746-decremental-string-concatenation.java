class Solution {
    private Integer[][][] dp;

    public int minimizeConcatenatedLength(String[] words) {
        dp = new Integer[words.length]['z' - 'a' + 1]['z' - 'a' + 1];
        
        int firstLen = words[0].length();

        return firstLen + dfs(words, 1, words[0].charAt(0), words[0].charAt(firstLen - 1));
    }

    private int dfs(String[] words, int next, char left, char right) {
        if (next == words.length) {
            return 0;
        }

        int leftIndex = left - 'a';
        int rightIndex = right - 'a';
        if (dp[next][leftIndex][rightIndex] != null) {
            return dp[next][leftIndex][rightIndex];
        }

        int mergeLeft = 0;
        int mergeRight = 0;
        String nextWord = words[next];
        int n = nextWord.length();
        char nextLeft = nextWord.charAt(0);
        char nextRight = nextWord.charAt(n - 1);

        mergeLeft = n + dfs(words, next + 1, nextLeft, right);
        if (nextRight == left) {
            mergeLeft--;
        }

        mergeRight = n + dfs(words, next + 1, left, nextRight);
        if (nextLeft == right) {
            mergeRight--;
        }

        dp[next][leftIndex][rightIndex] = Math.min(mergeLeft, mergeRight);

        return dp[next][leftIndex][rightIndex];
    }
}