class Solution {
    public int bulbSwitch(int n) {
        int answer = 0;
        
        for (int i = 1; i * i <= n ; i++) {
            answer++;
        }

        return answer;
    }
}