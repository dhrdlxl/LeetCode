class Solution {
    public boolean isPowerOfTwo(int n) {
        int num = 1;
        for (int i = 0; i < 31; i++) {
            if (num == n) {
                return true;
            }
            num = (num << 1);
        }
        
        return false;
    }
}