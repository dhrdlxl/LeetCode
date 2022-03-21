class Solution {
    public int maxProduct(int[] nums) {
        int answer = -11;
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        answer = nums[0];
        
        for (int index = 1; index < nums.length; index++) {
            dpMin[index] = getMin(
                            getMin(nums[index], dpMin[index - 1] * nums[index]),
                            dpMax[index - 1] * nums[index]);
            dpMax[index] = getMax(
                            getMax(nums[index], dpMax[index - 1] * nums[index]),
                            dpMin[index - 1] * nums[index]);
            
            answer = getMax(answer, dpMax[index]);
        }
        
        return answer;
    }
    
    private int getMin(int a, int b) {
        return a < b ? a : b;
    }
    private int getMax(int a, int b) {
        return a > b ? a : b;
    }
}