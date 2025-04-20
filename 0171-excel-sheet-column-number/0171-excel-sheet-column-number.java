class Solution {
    public int titleToNumber(String columnTitle) {
        int answer = 0;
        int x = 1;
        
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            answer += (x * (int)(columnTitle.charAt(i) - 'A' + 1));
            x *= 26;
        }

        return answer;
    }
}