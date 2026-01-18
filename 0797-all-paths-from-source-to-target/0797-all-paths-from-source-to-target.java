class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new LinkedList<>();
        int endNode = graph.length - 1;
        Queue<NodeInfo> queue = new LinkedList<>();
        
        for (int next : graph[0]) {
            LinkedList<Integer> path = new LinkedList<>();
            path.add(0);
            path.add(next);
            queue.offer(new NodeInfo(next, path));
        }
        
        while (!queue.isEmpty()) {
            NodeInfo curNode = queue.poll();

            if (curNode.node == endNode) {
                answer.add(curNode.path);
                continue;
            }
            
            for (int next: graph[curNode.node]) {
                LinkedList<Integer> nextPath = new LinkedList<>();
                nextPath.addAll(curNode.path);
                nextPath.add(next);

                queue.offer(new NodeInfo(next, nextPath));
            }
        }

        return answer;
    }

    private class NodeInfo {
        public int node;
        public List<Integer> path;

        public NodeInfo(int node, List<Integer> path) {
            this.node = node;
            this.path = path;
        }
    }
}