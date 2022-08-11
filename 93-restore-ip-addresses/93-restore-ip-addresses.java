class Solution {
    List<String> answer;
    public List<String> restoreIpAddresses(String s) {
        answer = new LinkedList<String>();
        
        if (s.length() < 4 || s.length() > 12) {
            return answer;
        }
        
        simulation(s, 1, 0, new StringBuilder());
        
        return answer;
    }
    
    private void simulation(String s, int step, int index, StringBuilder sb) {
        if (step == 4) {
            if (index < s.length()) {
                String num = s.substring(index, s.length());
                
                if (isValidIP(num)) {
                    sb.append(num);
                    answer.add(sb.toString());
                    sb.delete(sb.length() - num.length(), sb.length());
                }
            }
            
            return;
        }
        
        for (int len = 1; len <= 3; len++) {
            if (index + len < s.length()) {
                String num = s.substring(index, index + len);
                
                // IP 유효성 검사
                if (isValidIP(num))
                {
                    sb.append(num + ".");
                    simulation(s, step + 1, index + len, sb);
                    sb.delete(sb.length() - len - 1, sb.length());  
                }
            }
        }
    }
    
    private boolean isValidIP(String num) {
        if (num.charAt(0) == '0' && num.length() > 1)
            return false;
        else if (Integer.parseInt(num) > 255)
            return false;
        
        return true;
    }
}