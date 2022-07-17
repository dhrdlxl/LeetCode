class Solution {
    private final int MAXNUM = 100001;
    public int minSubArrayLen(int target, int[] nums) {
        int answer = MAXNUM;
        int sum = 0;
        
        for (int start = 0, end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (start <= end && sum >= target) {
                answer = Math.min(answer, end - start + 1);
                
                sum -= nums[start];
                start++;
            }
        }
        
        if (answer == MAXNUM)
            answer = 0;
        
        return answer;
    }
}