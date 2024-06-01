class Solution {
    public int getWinner(int[] arr, int k) {
        int count = 0;
        int max = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            
            if (num > max) {
                max = num;
                count = 1;
            } else if (num < max) {
                count++;
            }
            
            if (count == k) {
                return max;
            }
        }
        
        return max;
    }
}