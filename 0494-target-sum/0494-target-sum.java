class Solution {
    private int answer;
    public int findTargetSumWays(int[] nums, int target) {
        
        simulation(nums, target, 0);
            
        return answer;
    }
    
    private void simulation(int[] nums, int target, int step) {
        if (nums.length == step) {
            int sum = 0;
            
            for (int num : nums) {
                sum += num;    
            }
            
            if (sum == target) {
                answer++;
            }
            
            return;
        }
        
        simulation(nums, target, step + 1);
        nums[step] *= -1;
        simulation(nums, target, step + 1);
        nums[step] *= -1;
        
        return;
    }
}