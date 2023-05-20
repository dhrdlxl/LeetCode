class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry = 0;
        LinkedList<Integer> answer = new LinkedList<>();
        int indexA = num.length - 1;
        
        while (indexA >= 0 || k > 0) {
            int a = 0, b = 0;
            
            if (indexA >= 0) {
                a = num[indexA--];
            }
            if (k > 0) {
                b = k % 10;
                k /= 10;
            }
            
            int c = a + b + carry;
            carry = c / 10;
            
            answer.addFirst(c % 10);
        }
        
        if (carry > 0) {
            answer.addFirst(1);
        }
        
        return answer;
    }
}