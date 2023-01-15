class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> subStrings = new HashSet<>();
        
        for (int i = 0; i + k <= s.length(); i++) {
            subStrings.add(s.substring(i, i + k));
        }
        
        if (subStrings.size() == (1 << k)) {
            return true;
        }
        
        return false;
    }
}