class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int answer = 0;
        boolean checkLeft;
        boolean checkRight;
        int left = 0;
        int right = 0;
        
        
        for (int i = 0; i < flowerbed.length; i++) {
            checkLeft = true;
            checkRight = true;
            left = i - 1;
            right = i + 1;
            
            if (flowerbed[i] == 0) {
                if (left >= 0 && flowerbed[left] == 1) {
                    checkLeft = false;
                }
                
                if (right < flowerbed.length && flowerbed[right] == 1) {
                    checkRight = false;
                }

                if (checkLeft && checkRight) {
                    answer++;
                    flowerbed[i] = 1;
                }
            }
        }
        
        
        if (answer >= n) {
            return true;
        }
        
        return false;
    }
}