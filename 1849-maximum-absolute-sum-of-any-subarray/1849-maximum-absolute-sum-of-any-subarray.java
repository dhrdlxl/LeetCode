class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int answer = 0;
        int n = nums.length;
        int min = 0;
        int max = 0;

        for (int num : nums) {
            if (num > 0) {
                max += num;
                if (min + num < 0) {
                    min += num;
                } else {
                    min = 0;
                }
                answer = Math.max(answer, max);
            } else {
                min += num;
                if (max + num > 0) {
                    max += num;
                } else {
                    max = 0;
                }
                answer = Math.max(answer, min * -1);
            }
        }

        return answer;
    }
}