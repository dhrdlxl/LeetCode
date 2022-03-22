class Solution {
    public int search(int[] nums, int target) {
        int answer = -1;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (nums[left] == target) {
                answer = left;
                break;
            } else if (nums[mid] == target) {
                answer = mid;
                break;
            } else if (nums[right] == target) {
                answer = right;
                break;
            }
            
            if (nums[left] < nums[mid]) { // 왼쪽이 정렬된 상태
                if(nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // 오른쪽이 정렬된 상태
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return answer;
    }
}