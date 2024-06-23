class Solution {
    public int beautySum(String s) {
        int answer = 0;
        int n = s.length();
        int[][] count = new int[n + 1]['z' - 'a' + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 'z' - 'a' + 1; j++) {
                count[i][j] = count[i - 1][j];
            }
            char alphabet = s.charAt(i - 1);
            count[i][alphabet - 'a']++; 
        }
        
        int min;
        int max;
        
        for (int i = 1; i <= n - 1; i++) {    
            for (int j = i + 1; j <= n; j++) {
                min = Integer.MAX_VALUE;
                max = 0;
                for (int k = 0; k < 'z' - 'a' + 1; k++) {
                    if (count[j][k] - count[i - 1][k] > 0) {
                        min = Math.min(min, count[j][k] - count[i - 1][k]);
                        max = Math.max(max, count[j][k] - count[i - 1][k]);
                    }
                }
                
                if (min > 0) {
                    answer += (max - min);
                }
            }
        }
        
        return answer;
    }
}