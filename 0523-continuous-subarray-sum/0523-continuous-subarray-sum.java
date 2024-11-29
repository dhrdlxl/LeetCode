class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i]) % k;
            
            if (map.containsKey(sum)) {
                int j = map.get(sum);
                
                if (i - j > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        
        return false;
    }
}