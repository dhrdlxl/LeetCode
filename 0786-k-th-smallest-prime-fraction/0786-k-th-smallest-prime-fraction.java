class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<FractionInfo> pq = new PriorityQueue<>();
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.add(new FractionInfo((double)arr[i] / arr[j], arr[i], arr[j]));
            }
        }
        
        while (k > 1) {
            k--;
            pq.poll();
        }
        
        return new int[]{pq.peek().left, pq.peek().right};
    }
    
    class FractionInfo implements Comparable<FractionInfo> {
        public double fraction;
        public int left;
        public int right;
        
        public FractionInfo(double fraction, int left, int right) {
            this.fraction = fraction;
            this.left = left;
            this.right = right;
        }
        
        @Override
        public int compareTo(FractionInfo fractionInfo) {
            return this.fraction > fractionInfo.fraction ? 1 : -1;
        }
    }
}