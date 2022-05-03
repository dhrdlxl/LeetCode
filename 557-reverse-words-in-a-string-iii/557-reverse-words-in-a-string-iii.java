import java.util.*;

class Solution {
    public String reverseWords(String s) {
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        String space = "";
        while(st.hasMoreTokens()) {
            char[] word = st.nextToken().toCharArray();
            int left = 0;
            int right = word.length - 1;
            
            while (left < right) {
                char temp = word[left];
                word[left] = word[right];
                word[right] = temp;
                
                left++;
                right--;
            }
            
            answer.append(space);
            answer.append(word);
            
            space = " ";
        }
        
        return answer.toString();
    }
}