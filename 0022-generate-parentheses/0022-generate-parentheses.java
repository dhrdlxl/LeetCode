class Solution {
    private static final int LEFT = 1;
    private static final int RIGHT = 0;
    private List<String> answer;
    private int[] arr;
    
    public List<String> generateParenthesis(int n) {
        answer = new LinkedList<String>();
        arr = new int[n * 2];
        
        simulation(0, 0, n);
        
        return answer; 
    }
    
    private void simulation(int step, int balance, int leftCount) {
        if (step == arr.length) {
            StringBuilder sb = new StringBuilder();
            
            for (int check : arr) {
                if (check == LEFT) {
                    sb.append('(');
                } else {
                    sb.append(')');
                }
            }
            
            answer.add(sb.toString());
            return;
        }
        
        if (leftCount > 0) {
            arr[step] = LEFT;
            simulation(step + 1, balance + 1, leftCount - 1);
        }
        
        if (balance > 0) {
            arr[step] = RIGHT;
            simulation(step + 1, balance - 1, leftCount);
        }
    }
}