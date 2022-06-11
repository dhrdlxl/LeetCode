class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0;
        int right = m * n - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / n;
            int col = mid % n;
            
            if (target < matrix[row][col]) {
                right = mid - 1;
            } else if (target > matrix[row][col]) {
                left = mid + 1;
            } else if (target == matrix[row][col]) {
                return true;
            }
        }
        
        return false;
    }
}