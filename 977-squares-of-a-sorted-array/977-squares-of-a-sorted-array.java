class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] answer = new int[nums.length];
        int index = nums.length - 1;
        
        while (left <= right) {
            int leftNum = (nums[left] < 0 ? nums[left] * -1 : nums[left]);
            int rightNum = (nums[right] < 0 ? nums[right] * -1 : nums[right]);
            
            if (leftNum < rightNum) {
                answer[index] = (rightNum * rightNum);
                right--;
            } else {
                answer[index] = (leftNum * leftNum);
                left++;
            }
            
            index--;
        }
        
        return answer;
    }
}