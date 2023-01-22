class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        
        while (left < right) {
            mid = (left + right) / 2;
            
            if (arr[mid - 1] > arr[mid]) {
                right = mid;
            } else if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
            else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                break;
            }
        }
        
        return mid;
    }
}