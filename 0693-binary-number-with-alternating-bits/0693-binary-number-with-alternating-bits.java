class Solution {
    public boolean hasAlternatingBits(int n) {
        StringBuilder sb = new StringBuilder();
        int before = -1;
        while (n > 0) {
            if (n % 2 == before) {
                return false;
            }
            before = n % 2;
            n /= 2;
        }
        
        return true;
    }
}