class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> answer = new ArrayList<>(m);
        
        for (int i = 0; i < m; i++) {
            answer.add(new ArrayList<Integer>(n));
        }
        
        k = k % (m * n);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = ((i * n + j) - k + (m * n)) % (m * n);
                int row = num / n;
                int col = num % n;
                
                answer.get(i).add(grid[row][col]);
            }
        }
        
        
        return answer;
    }
}