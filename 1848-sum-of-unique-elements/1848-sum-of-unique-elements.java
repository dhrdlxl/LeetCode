class Solution {
    public int sumOfUnique(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    answer -= num;
                }
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
                answer += num;
            }
        }

        return answer;
    }
}