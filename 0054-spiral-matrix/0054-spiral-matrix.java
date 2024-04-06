class Solution {
    private int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0;
        int c = 0;
        int nextR = 0;
        int nextC = 0;
        boolean hasNext = true;
        boolean[][] mask = new boolean[m][n];
        int direction = 0;
        
        while (hasNext == true) {
            hasNext = false;
            mask[r][c] = true;
            answer.add(matrix[r][c]);
            
            for (int i = 0; i < 4; i++) {
                nextR = r + move[direction][0];
                nextC = c + move[direction][1];
                
                if (nextR >= 0 && nextC >= 0 && nextR < m && nextC < n
                   && mask[nextR][nextC] == false) {
                    r = nextR;
                    c = nextC;
                    hasNext = true;
                    break;
                }
                
                direction = (direction + 1) % 4;
            }
        }
        
        return answer;
    }
}