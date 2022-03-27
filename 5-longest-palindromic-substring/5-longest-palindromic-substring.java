import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
        String answer = "";
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            //중심이 1개
            for (int j = 0; j < s.length(); j++) {
                if (0 <= i - j && i + j < s.length()) {
                    if (s.charAt(i - j) == s.charAt(i + j)) {
                        start = i - j;
                        end = i + j;
                    } else {
                        break;
                    }
                }
            }
            
            if (answer.length() < end - start + 1) {
                answer = s.substring(start, end + 1);
            }
            
            
            //중심이 2개
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                start = i;
                end = i + 1;
                for (int j = 0; j < s.length(); j++) {
                    if (0 <= i - j && i + 1 + j < s.length()) {
                        if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
                            start = i - j;
                            end = i + 1 + j;
                        } else {
                            break;
                        }
                    }
                }
            }
            
            if (answer.length() < end - start + 1) {
                answer = s.substring(start, end + 1);
            }
        }
        
        return answer;
    }
}