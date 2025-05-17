class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(i);
        }

        long sum = 0;
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            long count = entry.getValue().size();
            sum += getPairCount(count);
        }

        return getPairCount(n) - sum;
    }

    private long getPairCount(long n) {
        return (n + 1) * n / 2;
    }
}