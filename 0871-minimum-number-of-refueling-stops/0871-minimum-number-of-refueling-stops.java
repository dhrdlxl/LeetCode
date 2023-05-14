class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 < n2 ? 1 : -1);
        int location = 0;
        int index = 0;
        
        pq.add(startFuel);
        
        while (!pq.isEmpty()) {
            location += pq.peek();
            pq.remove();
            
            while (index < stations.length && stations[index][0] <= location) {
                pq.add(stations[index][1]);
                index++;
            }
            
            if (location >= target) {
                return answer;
            }
            
            answer++;
        }
        
        return -1;
    }
}