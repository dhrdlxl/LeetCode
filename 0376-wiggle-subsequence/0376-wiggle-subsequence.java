class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] minus = new int[n];
        int[] plus = new int[n];
        minus[0] = 1;
        plus[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    minus[i] = Math.max(minus[i], plus[j] + 1);
                } else if (nums[j] < nums[i]) {
                    plus[i] = Math.max(plus[i], minus[j] + 1);
                } else {
                    minus[i] = Math.max(minus[i], minus[j]);
                    plus[i] = Math.max(plus[i], plus[j]);
                }
            }
        }

        return Math.max(minus[n - 1], plus[n - 1]);
    }
}