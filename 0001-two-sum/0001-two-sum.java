class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new LinkedList<Integer>());
            }
            map.get(nums[i]).offer(i);
        }
        
        for (int num : nums) {
            if (map.containsKey(target - num)) {
                if (num == (target - num) && map.get(num).size() < 2) {
                    continue;
                }
                answer[0] = map.get(num).poll();
                answer[1] = map.get(target - num).poll();
                break;
            }
        }
        
        return answer;
    }
}