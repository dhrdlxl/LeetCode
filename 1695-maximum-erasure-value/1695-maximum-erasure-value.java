class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[nums.length + 1];
        int start = 0;
        
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            
            dp[i] = dp[i - 1] + num;
            
            if (map.containsKey(num)) {
                int nextStart = map.get(num);
                
                for (int j = start; j < nextStart; j++) {
                    map.remove(nums[j]);
                }
                
                start = nextStart;
            }
            
            map.put(num, i);
            
            answer = Math.max(answer, dp[i] - dp[start]);
        }
        
        return answer;
    }
}