class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer>[] board = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            board[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            board[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            boolean[] mask = new boolean[n];
            dfs(i, board, mask);

            List<Integer> visit = new ArrayList<>();
            for (int node = 0; node < n; node++) {
                if (mask[node]) {
                    visit.add(node);
                }
            }

            answer.add(visit);
        }

        return answer;
    }

    private void dfs(int curNode, List<Integer>[] board, boolean[] mask) {
        for (int nextNode : board[curNode]) {
            if (mask[nextNode] == false) {
                mask[nextNode] = true;
                dfs(nextNode, board, mask);
            }
        }
    }
}