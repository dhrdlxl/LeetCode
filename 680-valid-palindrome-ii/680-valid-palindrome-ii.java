class Solution {
    public boolean validPalindrome(String s) {
        return solution(s, 0);
    }
    
    private boolean solution(String s, int diff) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (diff >= 1) {
                    return false;
                } else {
                    return (solution(s.substring(left + 1, right + 1), 1) || solution(s.substring(left, right), 1));
                }
            }
        }
        
        return true;
    }
}