class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0 ; i < nums.length; i++) {
            while (!q.isEmpty() && q.peek() + k <= i) {
                q.remove();
            }
            
            if (q.size() % 2 == 1) {
                nums[i] = (nums[i] + 1) % 2;
            }
            
            if (nums[i] == 0) {
                if (i < nums.length - (k - 1)) {
                    answer++;
                    q.add(i);
                } else {
                    return -1;
                }
            }
        }
        
        return answer;
    }
}