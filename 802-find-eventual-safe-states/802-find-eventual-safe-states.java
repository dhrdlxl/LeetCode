class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] degree = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer>[] newGraph = new ArrayList[graph.length + 1];
        for (int i = 0; i < graph.length; i++) {
            newGraph[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < graph.length; i++) { // graph 뒤집기
            int from = i;
            for (int j = 0; j < graph[i].length; j++) {
                int to = graph[i][j];
                newGraph[to].add(from);
                degree[i]++;
            }
            
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            answer.add(node);
            
            for (int i = 0; i < newGraph[node].size(); i++) {
                int nextNode = newGraph[node].get(i);
                degree[nextNode]--;
                
                if (degree[nextNode] == 0) {
                    queue.offer(nextNode);
                }
            }
        }
        
        answer.sort(Comparator.naturalOrder());
        
        
        
        return answer;
    }
}