class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        int r_start = 0;
        int r_end = n - 1;
        while (r_start < r_end) {
            for (int c = 0; c < n; c++) {
                swap(matrix, r_start, c, r_end, c);
            }
            
            r_start++;
            r_end--;
        }
        
        for (int r = 0; r < n; r++) {
            for (int c = r + 1; c < n; c++) {
                swap(matrix, r, c, c, r);
            }
        }
    }
    
    private void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}