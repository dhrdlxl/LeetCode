class Solution {
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        } else if (n == 1) {
            return  new int[]{0, 1};
        }
        
        int[] answer = new int[n + 1];
        answer[1] = 1;
        int index = 2;
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        
        while (!q.isEmpty() && index < n + 1) {
            int num = q.remove();
            
            answer[index++] = num;
            q.add(num);
            
            if (index < n + 1) {
                answer[index++] = num + 1;
                q.add(num + 1);
            }
        }
        
        return answer;
    }
}