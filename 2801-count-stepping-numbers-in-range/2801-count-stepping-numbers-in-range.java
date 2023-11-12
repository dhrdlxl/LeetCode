class Solution {
    private final int MOD = 1000000007;
    private Integer dp[][][][];
    
    public int countSteppingNumbers(String low, String high) {
        dp = new Integer[low.length() + 1][10][2][2];
        int lowCount = getCount(low, 0, 0, 1, 1);
        
        dp = new Integer[high.length() + 1][10][2][2];
        int highCount = getCount(high, 0, 0, 1, 1);
        
        return (highCount - lowCount + isStep(low) + MOD) % MOD;
    }
    
    private int getCount(String number, int step, int prevDigit, int hasBound, int isZero) {
        if (step >= number.length()) {
            if (isZero == 1) {
                return 0;
            }
            
            return 1;
        }
        
        if (dp[step][prevDigit][hasBound][isZero] != null) {
            return dp[step][prevDigit][hasBound][isZero];
        }
        
        int count = 0;
        int limit = 9;
        if (hasBound ==  1) {
            limit = number.charAt(step) - '0';
        }
        
        for (int i = 0; i <= limit; i++) {
            int nextIsZero = (isZero == 1 && i == 0) ? 1 : 0;
            int nextHasBound = (hasBound == 1 && i == limit) ? 1 : 0;
            
            if (isZero == 1 || Math.abs(i - prevDigit) == 1) {
                count = (count + getCount(number, step + 1, i, nextHasBound, nextIsZero)) % MOD;
            }
        }
        
        dp[step][prevDigit][hasBound][isZero] = count;
        
        return count;
    }
    
    private int isStep(String number) {
        
        for (int i = 0; i < number.length() - 1; i++) {
            if (Math.abs(number.charAt(i + 1) - number.charAt(i)) != 1) {
                return 0;
            }
        }
        
        return 1;
    }
}