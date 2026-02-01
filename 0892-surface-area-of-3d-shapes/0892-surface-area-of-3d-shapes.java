class Solution {
    public int surfaceArea(int[][] grid) {
        int answer = 0;
        int max = 0;
        int n = grid.length;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                answer += grid[row][col];
                max = Math.max(max, grid[row][col]);
            }
        }
        
        answer *= 6;

        for (int i = 0; i < max; i++) {
            answer -= countNeighbor(grid);

            int count = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] > 0) {
                        grid[row][col]--;
                        count++;
                    }
                }
            }

            if (i > 0) {
                answer -= (2 * count);
            }
        }

        return answer;
    }

    private int countNeighbor(int[][] grid) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;
        int n = grid.length;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] > 0) {
                    for (int[] direction : directions) {
                        int nextRow = row + direction[0];
                        int nextCol = col + direction[1];
                        if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] > 0) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}