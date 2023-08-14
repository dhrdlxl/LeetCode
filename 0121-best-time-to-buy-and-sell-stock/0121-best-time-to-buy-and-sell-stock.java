class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int min = 100001;
        
        for (int price : prices) {
            answer = Math.max(answer, price - min);
            min = Math.min(min, price);
        }
        
        return answer;
    }
}