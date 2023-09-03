class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int['z' - 'a' + 1];
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}