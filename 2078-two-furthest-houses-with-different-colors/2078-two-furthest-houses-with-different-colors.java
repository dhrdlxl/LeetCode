class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int answer = 0;
        int[] houses = new int[101];
        
        for (int i = 0; i < 101; i++) {
            houses[i] = -1;
        }
        
        
        for (int i = 0; i < n; i++) {
            int color = colors[i];
            
            for (int j = 0; j < 101; j++) {
                if (j != color && houses[j] != -1) {
                    answer = Math.max(answer, i - houses[j]);
                }
            }
            
            if (houses[color] == -1) {
                houses[color] = i;
            }
        }
        
        return answer;
    }
}