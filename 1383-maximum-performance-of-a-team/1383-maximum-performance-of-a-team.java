import java.util.*;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i] = new int[] {efficiency[i], speed[i]};
        }
        
        Arrays.sort(engineers, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long speedSum = 0;
        long performance = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                speedSum -= pq.poll();
            }
            pq.add(engineers[i][1]);//speed;
            speedSum += engineers[i][1];
            performance = Math.max(performance, speedSum * engineers[i][0]);
        }
        
        return (int) (performance % 1000000007);
    }
}