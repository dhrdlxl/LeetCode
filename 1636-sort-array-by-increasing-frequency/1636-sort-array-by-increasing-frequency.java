class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        
        int[] answer = Arrays.stream(nums)
            .boxed()
            .sorted((a, b) -> map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b))
            .mapToInt(num -> num)
            .toArray();
            
        
        return answer;
    }
}