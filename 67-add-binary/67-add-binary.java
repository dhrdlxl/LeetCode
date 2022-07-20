class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder answer = new StringBuilder();
        
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        for (; aIndex >= 0 || bIndex >= 0; aIndex--, bIndex--) {
            int aNum = 0;
            int bNum = 0;
            if (aIndex >= 0) {
                aNum = (a.charAt(aIndex) - '0');
            }
            if (bIndex >= 0) {
                bNum = (b.charAt(bIndex) - '0');
            }
            
            int sum = aNum + bNum + carry;
            
            if (sum / 2 == 1) {
                carry = 1;
            } 
            else {
                carry = 0;
            }
            
            answer.insert(0, (char)('0' + sum % 2));
        }
        
        if (carry == 1) {
            answer.insert(0, '1');
        }
        
        return answer.toString();
    }
}