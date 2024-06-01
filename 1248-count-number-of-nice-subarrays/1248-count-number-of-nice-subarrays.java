class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int answer = 0;
        int count = 0;
        int[] countEven = new int[nums.length + 1];
        int len = 0;
        
        for (int num : nums) {
            if (num % 2 == 1) {
                countEven[len] = count;
                len++;
                count = 0;
            } else {
                count++;
            }
        }
        
        countEven[len] = count;
        len++;
        
        for (int left = 0, right = k; right < len; left++, right++) {
            answer += ((countEven[left] + 1) * (countEven[right] + 1));
        }
        
        return answer;
    }
}