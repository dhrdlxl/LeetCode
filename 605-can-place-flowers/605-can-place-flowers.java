class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        
        for (int index = 0; index < flowerbed.length; index++) {
            if (flowerbed[index] == 1)
                continue;
            
            int left = index - 1;
            int right = index + 1;
            
            if ((left < 0 || flowerbed[left] == 0) 
                && (flowerbed.length <= right || flowerbed[right] == 0)) {
                n--;
                flowerbed[index] = 1;
            }
            
            if (n == 0) {
                return true;
            }
        }
        
        return false;
    }
}