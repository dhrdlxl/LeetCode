class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int left = 0;
        int right = n - 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                answer[left] = num;
                left++;
            } else {
                answer[right] = num;
                right--;
            }
        }

        return answer;
    }
}