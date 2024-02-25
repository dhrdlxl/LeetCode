class Solution {
    private final char[] ban = {'b', 'a', 'n'};
    private final char[] lo = {'l', 'o'};
    
    public int maxNumberOfBalloons(String text) {
        int answer = Integer.MAX_VALUE;
        int[] count = new int['z' - 'a' + 1];
        
        for (char ch : text.toCharArray()) {
            count[ch - 'a']++;
        }
        
        for (char ch : ban) {
            answer = Math.min(answer, count[ch - 'a']);
        }
        
        for (char ch : lo) {
            answer = Math.min(answer, count[ch - 'a'] / 2);
        }
        
        return answer;
    }
}