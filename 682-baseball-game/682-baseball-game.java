class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        
        for (String operation : ops) {
            if (operation.equals("+")) {
                int second = st.pop();
                int first = st.peek();
                
                st.push(second);
                st.push(first + second);
            } else if (operation.equals("D")) {
                int before = st.peek();
                
                st.push(before * 2);
            } else if (operation.equals("C")) {
                st.pop();
            } else { //number
                st.push(Integer.parseInt(operation));
            }
        }
        
        int answer = 0;
        while (!st.isEmpty()) {
            answer += st.pop();
        }
        
        return answer;
    }
}