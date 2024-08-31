class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        boolean increase = nums[n - 1] > nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == 0) {
                continue;
            } else if (increase != diff > 0) {
                return false;
            }
        }
        
        return true;
    }
}