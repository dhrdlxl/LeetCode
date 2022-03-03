class Solution {
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        
        for (int index = 0; index < len - 1; index++) {
            int maxNum = 0;
            
            for (int right = index + 1; right < len; right++) {
                if (maxNum < arr[right]) {
                    maxNum = arr[right];
                }
            }
            
            arr[index] = maxNum;
        }
        
        arr[len - 1] = -1;
        
        return arr;
    }
    
}