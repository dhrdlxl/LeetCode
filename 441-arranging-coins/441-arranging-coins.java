class Solution {
    public int arrangeCoins(int n) {
        int multi = 1;
        int row = 0;
        
        while (multi >= 0) {
            row++;
            
            if (row % 2 == 0) {
                multi = (row / 2 * (row + 1));
            } else if ((row + 1) % 2 == 0) {
                multi = (row * ((row + 1) / 2));
            }
            
            if (n < multi)
                break;
        }
        
        return row - 1;
    }
}