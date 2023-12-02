class Solution {
    public int characterReplacement(String s, int k) {
        int answer = 0;
        int[] count = new int['Z' - 'A' + 1];
        
        for (int i = 0; i < s.length(); i++) {
            char alphabet = s.charAt(i);
            count[alphabet - 'A']++;
            
            int sum = 0;
            int maxCount = 0;
            for (int j = 0; j < 'Z' - 'A' + 1; j++) {
                sum += count[j];
                maxCount = Math.max(maxCount, count[j]);
            }
            
            if (sum - maxCount <= k) {
                answer = Math.max(answer, sum);
            } else {
                count[s.charAt(i - sum + 1) - 'A']--;
            }
        }
        
        return answer;
    }
}