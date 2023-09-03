class Solution {
    public int countVowelPermutation(int n) {
        int[] count = {1, 1, 1, 1, 1};
        int[] temp;
        int mod = 1000000007;
        
        while (--n > 0) {
            temp = count.clone();
            count[0] = ((temp[1] + temp[2]) % mod + temp[4]) % mod;
            count[1] = (temp[0] + temp[2]) % mod;
            count[2] = (temp[1] + temp[3]) % mod;
            count[3] = temp[2];
            count[4] = (temp[2] + temp[3]) % mod;
        }
        
        int answer = 0;
        for (int num : count) {
            answer = (answer + num) % mod;
        }
        
        return answer;
    }
}