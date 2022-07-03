class Solution {
    public boolean canJump(int[] nums) {
        boolean[] canJump = new boolean[nums.length];
        canJump[0] = true;
        
        for (int i = 0; i < nums.length; i++) {
            if (canJump[i]) {
                if (i + nums[i] >= nums.length)
                    return true;
                
                for (int j = i + nums[i]; j > i; j--) {
                    if (canJump[j] == true)
                        break;
                    canJump[j] = true;
                }
                
            }
        }
        
        if (canJump[nums.length - 1] == true)
            return true;
        
        return false;
    }
}