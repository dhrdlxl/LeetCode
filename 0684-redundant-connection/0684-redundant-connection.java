class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] answer = new int[2];
        int[] count = new int[edges.length + 1];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for (int[] edge : edges) {
            count[edge[0]]++;
            count[edge[1]]++;
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<Integer>());
            }
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<Integer>());
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        for (int i = 1; i <= edges.length; i++) {
            if (count[i] == 1){
                dfs(count, i, map);
            }
        }
        
        for (int i = edges.length - 1; i >= 0; i--) {
            int left = edges[i][0];
            int right = edges[i][1];
            
            if (count[left] > 1 && count[right] > 1) {
                return new int[] {left, right};
            }
        }
        
        return null;
    }
    
    private void dfs(int[] count, int node, HashMap<Integer, ArrayList<Integer>> map) {
        count[node] = 0;
        
        for (int connectNode : map.get(node)) {
            if (count[connectNode] > 0) {
                count[connectNode]--;
                
                if (count[connectNode] == 1) {
                    dfs(count, connectNode, map);
                }
            }
        }
    }
}