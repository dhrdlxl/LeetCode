class Solution {
    public int maxTwoEvents(int[][] events) {
        int answer = 0;
        int before_max = 0;
        
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for (int[] event : events) {
            while (!q.isEmpty() && q.peek()[0] < event[0]) {
                before_max = Math.max(before_max, q.poll()[1]);
            }
            
            answer = Math.max(answer, before_max + event[2]);
            q.add(new int[]{event[1], event[2]});
        }
            
        return answer;
    }
}