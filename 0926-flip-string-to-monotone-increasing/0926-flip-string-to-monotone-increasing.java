class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int answer = n;
        int[][] count = new int[n + 1][2];
        
        for (int i = 1; i <= n; i++) {
            count[i][1] = count[i - 1][1] + (s.charAt(i - 1) == '1' ? 1 : 0);
            count[n - i][0] = count[n - i + 1][0] + (s.charAt(n - i) == '0' ? 1 : 0); 
        }
        
        for (int i = 0; i <= n; i++) {
            answer = Math.min(answer, count[i][0] + count[i][1]);
        }
        
        return answer;
    }
}