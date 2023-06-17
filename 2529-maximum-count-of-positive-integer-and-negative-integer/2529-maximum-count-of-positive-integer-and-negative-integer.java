class Solution {
    public int maximumCount(int[] nums) {
        Map<Integer, List<Integer>> map = Arrays.stream(nums).boxed()
            .collect(Collectors.groupingBy(num -> {
            if (num < 0) {
                return -1;
            } else if (num > 0) {
                return 1;
            } else {
                return 0;
            }
        }));
        
        return Math.max(map.getOrDefault(-1, new ArrayList<>()).size(), map.getOrDefault(1, new ArrayList<>()).size());
    }
}