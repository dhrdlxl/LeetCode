class Solution {
    private int countNodes;
    private int countEdges;
    private boolean[] mask;

    public int countCompleteComponents(int n, int[][] edges) {
        int answer = 0;
        List<Integer>[] board = new ArrayList[n];
        mask = new boolean[n];

        for (int i = 0; i < n; i++) {
            board[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            board[edge[0]].add(edge[1]);
            board[edge[1]].add(edge[0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (mask[i] == false) {
                countNodes = 0;
                countEdges = 0;

                dfs(board, i);

                if (countNodes * (countNodes - 1) == countEdges) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private void dfs (List<Integer>[] board, int curNode) {
        mask[curNode] = true;
        countNodes++;
        countEdges += board[curNode].size();

        for (int nextNode : board[curNode]) {
            if (mask[nextNode] == false) {
                dfs(board, nextNode);
            }
        }
    }
}