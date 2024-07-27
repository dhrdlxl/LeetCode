class Solution {
    public long minCost(int[] nums, int[] cost) {
        long answer = 0;
        int left = 1000000;
        int right = 0;
        
        for (int num : nums) {
            left = Math.min(num, left);
            right = Math.max(num, right);
        }
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid + 1);
            
            answer = Math.min(cost1, cost2); 
            
            if (cost1 < cost2) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private long getCost(int[] nums, int[] cost, int mid) {
        long sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += ((long)Math.abs(nums[i] - mid) * cost[i]);
        }
        
        return sum;
    }
}