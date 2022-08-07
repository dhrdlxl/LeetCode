class Solution {
    public int search(int[] nums, int target) {
        // 1. 가장 작은 값 Index 구하기(== rotate 횟수)
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (nums[right] < nums[mid]) { // 순서가 뒤집힌 경우
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        int pivotMove = right;// rotate한 횟수
        
        
        // 2. 1에서 구한 값을 적용해서 target Index 구하기
        left = 0;
        right = nums.length - 1;
        
        while (left <= right) {
            int mid = ((left + right) / 2 + pivotMove) % nums.length;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = (left + right) / 2 + 1;
            } else {
                right = (left + right) / 2 - 1;
            }
        }
        
        
        return -1;
    }
}