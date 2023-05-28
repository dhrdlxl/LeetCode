class Solution {
    public String freqAlphabets(String s) {
        StringBuilder answer = new StringBuilder();
        
        for (int index = s.length() - 1; index >= 0; index--) {
            if (s.charAt(index) == '#') {
                answer.append(convert(Integer.valueOf(s.substring(index - 2, index))));
                index -= 2;
            } else {
                answer.append(convert(Integer.valueOf(s.charAt(index) - '0')));
            }
            
        }
        
        return answer.reverse().toString();
    }
    
    private char convert(int num) {
        return (char)('a' + num - 1);
    }
}