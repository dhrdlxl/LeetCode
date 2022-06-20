class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char alphabetS = s.charAt(i);
            
            if (alphabetS == '#'&& stackS.size() > 0) {
                stackS.pop();
            } else if (alphabetS != '#') {
                stackS.push(alphabetS);
            }
        }
        
        for (int i = 0; i < t.length(); i++) {
            char alphabetT = t.charAt(i);
            
            if (alphabetT == '#' && stackT.size() > 0) {
                stackT.pop();
            } else if (alphabetT != '#') {
                stackT.push(alphabetT);
            }
        }
        
        if (stackS.size() != stackT.size()) {
            return false;
        }
        
        while (!stackS.isEmpty()) {
            char alphabetS = stackS.pop();
            char alphabetT = stackT.pop();
            if (alphabetS != alphabetT) {
                return false;
            }
        }
        
        return true;
     }
}