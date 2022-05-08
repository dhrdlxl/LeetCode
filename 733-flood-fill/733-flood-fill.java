class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<Integer> q = new LinkedList<>();
        int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        q.offer(sr);
        q.offer(sc);
        visited[sr][sc] = true;
        
        while (!q.isEmpty()) {
            int row = q.peek();
            q.poll();
            int col = q.peek();
            q.poll();
            
            for (int direction = 0; direction < 4; direction++) {
                int newRow = row + move[direction][0];
                int newCol = col + move[direction][1];
                
                if (newRow < 0 || newRow >= image.length || newCol < 0 || newCol >= image[0].length) {
                    continue;
                }
                if (visited[newRow][newCol] == false && image[sr][sc] == image[newRow][newCol]) {
                    image[newRow][newCol] = newColor;
                    visited[newRow][newCol] = true;
                    q.offer(newRow);
                    q.offer(newCol);
                }
            }
        }
        
        image[sr][sc] = newColor;
        
        return image;
    }
}