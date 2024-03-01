class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int['z' - 'a' + 1];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char alphabet = s.charAt(i);
            count[alphabet - 'a']++;
            
            if (count[alphabet - 'a'] == 1) {
                stack.push(i);
            } else if (count[alphabet - 'a'] > 1) {
                while (!stack.isEmpty()) {
                    char checkAlphabet = s.charAt(stack.peek());
                    if (count[checkAlphabet - 'a'] == 1) {
                        break;
                    } else if (count[checkAlphabet - 'a'] > 1) {
                        stack.pop();
                    }
                }
            }
        }
        
        return stack.isEmpty() ? -1 : stack.peek();
    }
}