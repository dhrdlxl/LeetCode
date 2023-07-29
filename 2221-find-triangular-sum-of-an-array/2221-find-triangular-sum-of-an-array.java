import java.util.*;

class Solution {
    public int triangularSum(int[] nums) {
        int N = nums.length;
        
        for (int i = 0; i < N - 1; i++) {
            for (int j = N - 1; j > i; j--) {
                nums[j] = (nums[j - 1] + nums[j]) % 10;
            }
        }
        
        return nums[N - 1];
    }
}