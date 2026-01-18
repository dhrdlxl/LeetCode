class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int before = nums[n - 1];
        int count = 2;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] != before) {
                count--;
                before = nums[i];

                if (count == 0) {
                    return nums[i];
                }
            }
        }

        return nums[n - 1];
    }
}