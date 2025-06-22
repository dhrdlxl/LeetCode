class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int answer = n;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        List<Integer> uniqueNums = new ArrayList<>(set);
        uniqueNums.sort(Comparator.naturalOrder());

        int left = 0;
        int right = 0;
        int len = uniqueNums.size();

        for (; left < len; left++) {
            while (right < len && uniqueNums.get(right) < uniqueNums.get(left) + n) {
                right++;
            }

            answer = Math.min(answer, n - (right - left));
        }

        return answer;
    }
}