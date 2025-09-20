class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] answer = new int[n / 3][3];

        Arrays.sort(nums);
        
        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2] - nums[i] <= k) {
                answer[i / 3][0] = nums[i];
                answer[i / 3][1] = nums[i + 1];
                answer[i / 3][2] = nums[i + 2];
            } else {
                return new int[0][];
            }
        }

        return answer;
    }
}