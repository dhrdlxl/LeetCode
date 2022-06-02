public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int answer = 0;
        int compare = (1 << 31);
        int temp = 1;
        
        for (int i = 1; i <= 32; i++) {
            if ((compare & n) != 0) {
                answer = (answer | temp);
            }
            compare = (compare >>> 1);
            temp = (temp << 1);
        }
        
        return answer;
    }
}