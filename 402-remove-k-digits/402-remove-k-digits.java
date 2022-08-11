class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder(num);
        
        
        // 1. (0 <= i < num.length) num[i] > num[i + 1] 일 경우, num[i] 삭제
        for (int i = 0; i < sb.length() - 1;) {
            if (k == 0) {
                break;
            }
            
            if (sb.charAt(i) > sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                
                if (i - 1 >= 0){
                    i--;
                }
                k--;
            } else {
                i++;
            }
        }
        
        
        // 2. k > 0 일 경우, sb의 가장 끝 k개 삭제
        // 1의 결과로 오름차순 형태가 만들어지게 되므로.
        sb = sb.delete(sb.length() - k, sb.length());
        
        
        // 3. 0000  0002 등의 경우 처리
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        if (sb.length() == 0) {
            return "0";
        }
        
        return sb.toString();
    }
}