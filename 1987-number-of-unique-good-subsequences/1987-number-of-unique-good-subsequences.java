class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int end0 = 0;
        int end1 = 0;
        int num = 1000000007;
        int hasZero = 0;
        
        for (char alphabet: binary.toCharArray()) {
            if (alphabet == '0') {
                end0 = (end0 + end1) % num;
                hasZero = 1;
            } else {
                end1 = (end0 + end1 + 1) % num;
            }
        }
        
        return (end0 + end1 + hasZero) % num;
    }
}