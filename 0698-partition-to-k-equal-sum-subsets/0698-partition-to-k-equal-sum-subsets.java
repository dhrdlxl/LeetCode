class Solution {
    private int[] nums;
    private int k;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.k = k;
        this.nums = new int[nums.length];
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            this.nums[i] = nums[i];
            sum += nums[i];
        }
        
        if (sum % k != 0) {
            return false;
        }
        
        return search(0, new int[k], sum / k);
    }
    
    private boolean search(int step, int[] subsets, int subsetSum) {
        if (step == nums.length) {
            return true;
        }
        
        for (int i = 0; i < k; i++) {
            if (nums[step] + subsets[i] <= subsetSum) {
                subsets[i] += nums[step];
                
                if (search(step + 1, subsets, subsetSum) == true) {
                    return true;
                }
                
                subsets[i] -= nums[step];
            }
            
            if (subsets[i] == 0) {
                break;
            }
        }
        
        return false;
    }
}