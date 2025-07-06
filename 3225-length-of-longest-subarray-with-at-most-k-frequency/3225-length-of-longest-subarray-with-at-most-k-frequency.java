class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int answer = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            
            answer = Math.max(answer, right - left + 1);
            right++;
        }

        return answer;
    }
}