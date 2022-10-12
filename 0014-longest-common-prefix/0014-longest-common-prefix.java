class Solution {
    public String longestCommonPrefix(String[] strs) {
        String answer = strs[0];
        
        for (String str : strs) {
            int index = 0;
            for (int i = 0; i < Math.min(answer.length(), str.length()); i++) {
                if (answer.charAt(i) == str.charAt(i)) {
                    index++;
                } else {
                    break;
                }
            }
            
            answer = answer.substring(0, index);
            
            if (answer.length() == 0) {
                return "";
            }
        }
        
        
        
        return answer;
    }
}