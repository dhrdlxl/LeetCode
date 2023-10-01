class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int maxTime = 0;
        int answer = -1;
        int before = 0;
        
        for (int[] log : logs) {
            if (log[1] - before > maxTime) {
                maxTime = log[1] - before;
                answer = log[0];
            } else if (log[1] - before == maxTime) {
                answer = Math.min(answer, log[0]);
            }
            
            before = log[1];
        }
        
        return answer;
    }
}