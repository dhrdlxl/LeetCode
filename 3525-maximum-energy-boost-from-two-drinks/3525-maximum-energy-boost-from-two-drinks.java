class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] dp = new long[n][2];
        dp[0][0] = energyDrinkA[0];
        dp[0][1] = energyDrinkB[0];
        dp[1][0] = dp[0][0] + energyDrinkA[1];
        dp[1][1] = dp[0][1] + energyDrinkB[1];

        for (int i = 2; i < n; i++) {
            dp[i][0] = energyDrinkA[i] + Math.max(dp[i - 1][0], dp[i - 2][1]);
            dp[i][1] = energyDrinkB[i] + Math.max(dp[i - 1][1], dp[i - 2][0]);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}