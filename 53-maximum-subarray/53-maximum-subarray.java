class Solution {
    public int maxSubArray(int[] nums) {
        int answer = -10001;
        int before = -10001;
        
        for (int now : nums) {
            //비교 할 것
            //1. now + before vs now
            now = max(now + before, now);
            
            //2. answer vs now -> 더 큰 값을 answer
            answer = max(answer, now);
            
            before = now;
        }
        
        return answer;
    }
    
    private int max(int a,int b) {
        return a > b ? a : b;
    }
}