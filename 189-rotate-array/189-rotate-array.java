class Solution {
    public void rotate(int[] nums, int k) {
        k = (k % nums.length);
        int index = k;
        int[] temp = nums.clone();
        
        for (int i = 0; i <nums.length; i++) {
            nums[index] = temp[i];
            index = (index + 1) % nums.length;
        }
        
    }
}