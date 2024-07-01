class Solution {
    public String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }
        
        String answer = s;
        int start = 0;
        int end = k;
        String next = "";
        
        while(answer.length() > k) {
            start = 0;
            end = k;
            next = "";
            
            while (start < end) {
                String sub = answer.substring(start, end);
                int sum = 0;
                
                for (char num : sub.toCharArray()) {
                    sum += (num - '0');
                }
                
                next += Integer.toString(sum);
                
                start = end;
                end = (end + k) > answer.length() ? answer.length() : end + k;
            }
            
            answer = next;
        }
        
        return answer;
    }
}