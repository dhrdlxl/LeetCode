class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if (isSame(s1.charAt(0), s1.charAt(2), s2.charAt(0), s2.charAt(2))
           && isSame(s1.charAt(1), s1.charAt(3), s2.charAt(1), s2.charAt(3))) {
            return true;
        }
        
        return false;
    }
    
    private boolean isSame(char a, char b, char c, char d) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(a);
        sb1.append(b);
        sb2.append(c);
        sb2.append(d);
        
        if (sb1.toString().equals(sb2.toString()) 
            || sb1.reverse().toString().equals(sb2.toString())) {
            return true;
        }
        
        return false;
    }
}