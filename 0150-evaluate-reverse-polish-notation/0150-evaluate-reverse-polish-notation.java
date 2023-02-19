class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int num1 = 0;
        int num2 = 0;
        
        for (String token : tokens) {
            if (token.equals("+")) {
                num1 = st.pop();
                num2 = st.pop();
                st.push(num2 + num1);
            } else if (token.equals("-")) {
                num1 = st.pop();
                num2 = st.pop();
                st.push(num2 - num1);
            } else if (token.equals("*")) {
                num1 = st.pop();
                num2 = st.pop();
                st.push(num2 * num1);
            } else if (token.equals("/")) {
                num1 = st.pop();
                num2 = st.pop();
                st.push(num2 / num1);
            } else { // number
                st.push(Integer.parseInt(token));
            }
        }
        
        return st.pop();
    }
}