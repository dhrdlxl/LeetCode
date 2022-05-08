class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] road = new int[1001];
        int max = 0;
        
        for (int i = 0; i < trips.length; i++) {
            int numPassengers = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            
            for (int j = from; j < to; j++) {
                road[j] += numPassengers;
                if (max < road[j]) {
                    max = road[j];
                }
            }
        }
        
        if (max > capacity) {
            return false;
        }
        
        return true;
    }
}