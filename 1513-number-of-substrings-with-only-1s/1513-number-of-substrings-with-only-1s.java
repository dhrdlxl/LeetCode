class Solution {
    public int numSub(String s) {
        int answer = 0;
        long continuedCount = 0;
        
        for (char num : s.toCharArray()) {
            if (num == '0' && continuedCount > 0) {
                answer = (answer + getCount(continuedCount)) % 1000000007;
                continuedCount = 0;
            } else if (num == '1') {
                continuedCount++;
            }
        }
        
        if (continuedCount > 0) {
            answer = (answer + getCount(continuedCount)) % 1000000007;
        }
        
        return answer;
    }
    
    public int getCount(long num) {
        if (num % 2 == 0) {
            return (int)((num / 2) * (num + 1) % 1000000007);
        }
        
        return (int)(num * ((num + 1) / 2) % 1000000007);
    }
}