import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        StringTokenizer st = new StringTokenizer(path, "/");
        StringBuilder sb = new StringBuilder("");
        Stack<String> stack = new Stack<>();
        
        while(st.hasMoreTokens()) {
            String nextString = st.nextToken();
            
            if (nextString.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            else if (nextString.equals(".")) {
                continue;
            }
        
            stack.push(nextString);
        }
        
        if (stack.isEmpty()) {
            return "/";
        } 
        
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        
        return sb.toString();
    }
}