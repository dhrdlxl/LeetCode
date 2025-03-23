class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        double[] answer = new double[n + 1];
        List<Integer>[] board = new ArrayList[n + 1];
        Queue<Integer> q = new LinkedList<>();
        boolean[] mask = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            board[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            board[edges[i][0]].add(edges[i][1]);
            board[edges[i][1]].add(edges[i][0]);
        }

        q.offer(1);
        mask[1] = true;
        answer[1] = 1;

        while (!q.isEmpty() && t-- > 0) {
            for (int i = q.size(); i > 0; i--) {
                int cur = q.poll();
                int nextCount = 0;
                for (int next : board[cur]) {
                    if (mask[next] == false) {
                        nextCount++;
                    }
                }

                for (int next : board[cur]) {
                    if (mask[next] == false) {
                        answer[next] = answer[cur] / nextCount;
                        q.offer(next);
                        mask[next] = true;
                    }
                }

                if (nextCount > 0) {
                    answer[cur] = 0;
                }
            }
        }

        return answer[target];
    }
}