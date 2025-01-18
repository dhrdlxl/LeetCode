class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        int group = 0;
        boolean[] mask = new boolean[n];
        List<List<Integer>> board = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>());
        }

        for (int[] connection: connections) {
            board.get(connection[0]).add(connection[1]);
            board.get(connection[1]).add(connection[0]);
        }

        for (int i = 0; i < n; i++) {
            if (mask[i] == false) {
                dfs(i, board, mask);
                group++;
            }
        }

        return group - 1;
    }

    private void dfs(int cur, List<List<Integer>> board, boolean[] mask) {
        mask[cur] = true;

        for (int next: board.get(cur)) {
            if (mask[next] == false) {
                dfs(next, board, mask);
            }
        }
    }
}