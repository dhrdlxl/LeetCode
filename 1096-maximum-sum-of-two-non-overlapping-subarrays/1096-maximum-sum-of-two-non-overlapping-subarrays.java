class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] prefixSum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        return Math.max(getMax(prefixSum, firstLen, secondLen), getMax(prefixSum, secondLen, firstLen));
    }

    private int getMax(int[] prefixSum, int fL, int sL) {
        int max = 0;
        int maxFL = 0;

        for (int i = fL + sL; i < prefixSum.length; i++) {
            maxFL = Math.max(maxFL, prefixSum[i - sL] - prefixSum[i - fL - sL]);
            max = Math.max(max, maxFL + prefixSum[i] - prefixSum[i - sL]);
        }

        return max;
    }
}