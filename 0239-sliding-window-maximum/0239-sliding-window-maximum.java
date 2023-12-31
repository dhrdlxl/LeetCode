class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> slidingWindow = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> popNumCount = new HashMap<>();
        
        // s-w에 포함되어야 하는 값을 모두 넣음
        for (int i = 0; i < k; i++) {
            slidingWindow.add(nums[i]);
        }
        
        int max = slidingWindow.peek();
        answer.add(max);
        
        for (int i = k; i < nums.length; i++) {
            // 추가되는 값 sw에 넣음
            slidingWindow.add(nums[i]);
        
            // sw에서 빠져 나가는 값을 map에 넣음(num, count)
            int popCount = popNumCount.getOrDefault(nums[i - k], 0);
            popNumCount.put(nums[i - k], popCount + 1);
        
            // sw에 포함된 값 중 최대 값이 이미 빠져나간 값이라면 제거
            while (!slidingWindow.isEmpty() && popNumCount.getOrDefault(slidingWindow.peek(), 0) > 0) {
                int num = slidingWindow.poll();
                popNumCount.put(num, popNumCount.get(num) - 1);
            }
        
            // 최대값을 구함
            answer.add(slidingWindow.peek());
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}