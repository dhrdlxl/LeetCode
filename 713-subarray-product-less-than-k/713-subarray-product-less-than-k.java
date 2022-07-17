class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int answer = 0;
        int start = 0;
        int end = 0;
        int product = 1;
        
        for (; end < nums.length; end++) {
            product *= nums[end];
            
            while (start <= end && k <= product) {
                product /= nums[start];
                start++;
            }
            
            answer += end - start + 1;
        }
        
        return answer;
    }
}