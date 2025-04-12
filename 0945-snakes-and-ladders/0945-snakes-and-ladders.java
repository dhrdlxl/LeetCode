class Solution {
    private final int BLANK = Integer.MAX_VALUE;
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] visitBoard = new int[n * n + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n * n + 1; i++) {
            visitBoard[i] = BLANK;
        }

        q.add(1);
        visitBoard[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.remove();
            int nextMax = Math.min(cur + 6, n * n);
            
            for (int next = cur + 1; next <= nextMax; next++) {
                int snakeOrLadder = find(board, next);
                int nextPos = (snakeOrLadder > 0 ? snakeOrLadder : next);

                if (visitBoard[nextPos] == BLANK) {
                    visitBoard[nextPos] = visitBoard[cur] + 1;
                    q.add(nextPos);
                }
            }
        }

        return visitBoard[n * n] == BLANK ? -1 : visitBoard[n * n];
    }

    private int find(int[][] board, int number) {
        int n = board.length;
        number--;

        int r = n - 1 - number / n;
        int c = (number / n % 2 == 0 ? number % n : n - 1 - number % n);

        return board[r][c];
    }
}