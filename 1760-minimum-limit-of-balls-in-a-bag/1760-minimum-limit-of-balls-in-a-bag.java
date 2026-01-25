class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int answer = 0;
        int left = 1;
        int right = Integer.MAX_VALUE;
        int maxBag = nums.length + maxOperations;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int bagCount = getBagCount(nums, mid);

            if (bagCount > maxBag) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int getBagCount(int[] nums, int maxBall) {
        int count = 0;
        
        for (int num : nums) {
            if (num <= maxBall) {
                count++;
            } else {
                count += num / maxBall;
                if (num % maxBall > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}