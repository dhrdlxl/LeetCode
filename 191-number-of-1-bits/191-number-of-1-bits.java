public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int answer = 0;
        
        long num = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & num) > 0) {
                System.out.print(i + " ");
                answer++;
            }
            num= num << 1;
        }
        
        return answer;
    }
}