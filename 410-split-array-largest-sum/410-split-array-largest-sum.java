class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0; //min
        int right = 0; //max
        
        for (int num : nums) {
            if (left < num) {
                left = num;
            }
            
            right += num;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (check(nums, m, mid) == true) { //mid 이하의 부분합 생성 시 가능 여부
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right;
    }
    
    private boolean check(int[] nums, int maxSplit, int maxSum) {
        int splitCount = 1;
        int sum = 0;
        
        for (int num: nums) {
            sum += num;
            
            if (sum > maxSum) {
                splitCount++;
                sum = num;
                
                if (splitCount > maxSplit) {
                    return false;
                }
            }
        }
        
        return true;
    }
}