class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        
        if (sum % 2 == 1 || max > sum / 2) {
            return false;
        }
        
        int target = sum / 2;
        boolean[][] check = new boolean[nums.length + 1][target + 1];
        
        for (int step = 1; step <= nums.length; step++) {
            int num = nums[step - 1];
            
            for (int beforeNum = 1; beforeNum < target; beforeNum++) {
                if (check[step - 1][beforeNum]) {
                    check[step][beforeNum] = true;
                    
                    if (num + beforeNum <= target) {
                        check[step][num + beforeNum] = true;
                    }     
                } 
            }
            
            check[step][num] = true;
            
            if (check[step][target]) {
                return true;
            }
        }
        
        return false;
    }
}