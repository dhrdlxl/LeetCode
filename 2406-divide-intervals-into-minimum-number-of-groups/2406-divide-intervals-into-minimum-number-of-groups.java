class Solution {
    public int minGroups(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        Arrays.sort(intervals, (o1, o2) -> {
           return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]; 
        });
        
        for (int[] interval : intervals) {
            if (pq.size() > 0 && pq.peek() < interval[0]) {
                pq.poll();
            }
            
            pq.add(interval[1]);
        }
        
        
        return pq.size();
    }
}