class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int N = nums.length;
        int answer = N + 1;
        long[] sum = new long[N + 1];
        Deque<Integer> index = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        
        for (int i = 0; i < N + 1; i++) {
            while (!index.isEmpty() && sum[i] - sum[index.getFirst()] >= k) {
                answer = Math.min(answer, i - index.pollFirst());
            }
            while (!index.isEmpty() && sum[i] <= sum[index.getLast()]) {
                index.pollLast();
            }
            
            index.addLast(i);
        }
        
        return answer <= N ? answer : -1;
    }
}