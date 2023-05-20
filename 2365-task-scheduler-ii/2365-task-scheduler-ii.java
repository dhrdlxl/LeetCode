class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Long> map = new HashMap<>();
        long answer = 0;
        
        for (int i = 0; i < tasks.length; i++) {
            answer++;
            int num = tasks[i];
            
            if (map.containsKey(num)) {
                long sub = answer - map.get(num) - 1L;
                answer += Math.max(0L, space - sub);
            }
            
            map.put(num, answer);
        }
        
        return answer;
    }
}