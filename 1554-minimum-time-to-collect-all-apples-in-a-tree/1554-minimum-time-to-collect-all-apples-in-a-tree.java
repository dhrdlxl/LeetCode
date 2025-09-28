class Solution {
    private Map<Integer, List<Integer>> tree;
    private boolean[] mask;
    private int answer;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        tree = new HashMap<>();
        mask = new boolean[n];

        for (int i = 0; i < edges.length; i++) {
            if (!tree.containsKey(edges[i][0])) {
                tree.put(edges[i][0], new ArrayList<>());
            }
            if (!tree.containsKey(edges[i][1])) {
                tree.put(edges[i][1], new ArrayList<>());
            }

            tree.get(edges[i][0]).add(edges[i][1]);
            tree.get(edges[i][1]).add(edges[i][0]);
        }

        dfs(0, hasApple);

        return answer > 0 ? (answer - 1) * 2 : 0;
    }

    private boolean dfs(int curNode, List<Boolean> hasApple) {
        boolean findApple = hasApple.get(curNode);
        mask[curNode] = true;

        if (tree.get(curNode) != null) {
            for (int nextNode : tree.get(curNode)) {
                if (mask[nextNode] == false) {
                    findApple = dfs(nextNode, hasApple) || findApple;
                }
            }
        }

        if (findApple) {
            answer++;
        }

        return findApple;
    }
}