class Solution {
    public int minFlips(String target) {
        int answer = 0;
        boolean converted = false;
        
        for (char num : target.toCharArray()) {
            if (num == '1' && converted == false
               || num == '0' && converted == true) {
                answer++;
                converted = !converted;
            }
        }
        
        return answer;
    }
}