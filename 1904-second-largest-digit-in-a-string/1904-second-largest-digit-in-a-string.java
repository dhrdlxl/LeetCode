class Solution {
    private boolean[] check = new boolean[10];
    public int secondHighest(String s) {
        for (Character ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                check[ch - '0'] = true;
            }
        }

        int count = 0;

        for (int i = 9; i >= 0; i--) {
            if (check[i] == true) {
                count++;
            }
            if (count == 2) {
                return i;
            }
        }

        return -1;
    }
}