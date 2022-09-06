class Solution {
    public int removeElement(int[] nums, int val) {
        int answerIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[answerIndex] = nums[i];
                answerIndex++;
            }
        }
        
        return answerIndex;
    }
}