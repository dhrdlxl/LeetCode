class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
        char before = ' ';
        for (char check : s.toCharArray()) {
            if (check == 'L') {
                countL++;
                
                if (countL >= 3) {
                    return false;
                }
            } else if (check == 'A') {
                countA++;
                countL = 0;
            } else if (check == 'P') {
                countL = 0;
            }
            
            before = check;
        }
        
        if (countA >= 2) {
            return false;
        }
        
        return true;
    }
}