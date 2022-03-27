class Solution {
    public int numSubseq(int[] nums, int target) {
        int answer = 0;
        int modNum = 1000000007;
        int left = 0;
        int right = nums.length - 1;
        int[] getPow = new int[nums.length + 1];
        
        getPow[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            getPow[i] = (getPow[i - 1] * 2) % modNum;
        } 
        
        Arrays.sort(nums);
        
        while (left <= right) {
            int min = nums[left];
            int max = nums[right];
            
            if (min + max > target) {
                right--;
            } else {
                /* [주의] 아래 처럼 제곱 연산하면 안됨
                  answer = (answer + ((1 << (right - left)) % mod) % mod); //2의 (right - left) 제곱
                 */
                answer = (answer + getPow[right - left]) % modNum;
                left++;
            }
        }
        
        return answer;
    }
}