class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int['z' - 'a' + 1];
        
        for (int index = 0; index < s1.length(); index++) {
            count[s1.charAt(index) - 'a']++;
        }
        
        for (int index = 0; index < s2.length(); index++) {
            count[s2.charAt(index) - 'a']--;
            if (index - s1.length() >= 0) {
                count[s2.charAt(index - s1.length()) - 'a']++;
            }
            
            if (check(count) == true) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean check(int[] count) {
        int sum = 0;
        for (int index = 0; index < count.length; index++) {
            if (count[index] != 0)
                return false;
        }
        
        return true;
    }
}