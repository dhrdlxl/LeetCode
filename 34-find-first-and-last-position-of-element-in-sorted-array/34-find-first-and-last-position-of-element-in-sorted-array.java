class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = {-1, -1};
        
        if (nums.length == 0) {
            return answer;
        }
        
        //1. LowerCase
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) { 
            mid = (left + right) / 2;
            
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        answer[0] = (nums[right] == target ? right : -1);
        
        
        //2. UpperCase
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        answer[1] =((left - 1 >= 0) && (nums[left -1] == target) ? left - 1 : -1);
        
        return answer;
    }
}