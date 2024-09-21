class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        
        for (int[] row: mat) {
            PriorityQueue<Integer> nextPq = new PriorityQueue<>(Collections.reverseOrder());
            
            for (int sum : pq) {
                for (int num : row) {
                    nextPq.add(sum + num);
                    
                    if (nextPq.size() > k) {
                        nextPq.poll();
                    }
                }
            }
            
            pq = nextPq;
        }
        
        return pq.peek();
    }
}
