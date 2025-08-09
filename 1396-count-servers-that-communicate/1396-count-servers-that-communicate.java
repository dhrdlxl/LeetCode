class Solution {
    public int countServers(int[][] grid) {
        int answer = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] mask = new boolean[n][m];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.add(i);
                    queue.add(j);
                }
            }

            if (queue.size() > 2) {
                while (!queue.isEmpty()) {
                    int row = queue.remove();
                    int col = queue.remove();
                    mask[row][col] = true;
                }
            } else {
                queue.clear();
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 1) {
                    queue.add(i);
                    queue.add(j);
                }
            }

            if (queue.size() > 2) {
                while (!queue.isEmpty()) {
                    int row = queue.remove();
                    int col = queue.remove();
                    mask[row][col] = true;
                }
            } else {
                queue.clear();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mask[i][j]) {
                    answer++;
                }
            }
        }

        return answer;
    }
}