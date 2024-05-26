class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double answer = Double.MAX_VALUE;
        int totalQuality = 0;
        List<Worker> workers = new ArrayList<>();
        
        for (int i = 0; i < quality.length; i++) {
            workers.add(new Worker(quality[i], wage[i]));
        }
        
        workers.sort((a, b) -> Double.compare(a.ratio, b.ratio));
        
        PriorityQueue<Worker> pq = new PriorityQueue<>((a, b) -> (b.quality - a.quality));
        
        
        for (Worker worker : workers) {
            pq.offer(worker);
            totalQuality += worker.quality;
            
            if (pq.size() > k) {
                Worker removeWorker = pq.poll();
                totalQuality -= removeWorker.quality;
            }
            
            if (pq.size() == k) {
                answer = Math.min(answer, totalQuality * worker.ratio);
            }
        }
        
        return answer;
    }
    
    class Worker {
        int quality;
        int wage;
        double ratio;
        
        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = ((double)wage / quality);
        }
    }
}