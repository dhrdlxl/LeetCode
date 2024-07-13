class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int answer = 0;
        int before = 0;
        
        for (int num : nums) {
            if (num == 1) {
                before += num;
                answer = Math.max(answer, before);
            } else {
                before = num;
            }
        }
        
        return answer;
    }
}