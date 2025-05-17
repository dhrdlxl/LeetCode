class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] countSum = new int[max + 1];

        for (int num : nums) {
            countSum[num]++;
        }

        for (int i = 1; i < countSum.length; i++) {
            countSum[i] += countSum[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                answer[i] = 0;
            } else {
                answer[i] = countSum[nums[i] - 1];
            }
        }

        return answer;
    }
}