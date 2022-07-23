class Solution {
    public int findCircleNum(int[][] isConnected) {
        int answer = 0;
        int n = isConnected.length;
        boolean[] mask = new boolean[n];
        
        for (int node = 0; node < n; node++) {
            if (mask[node] == false) {
                answer++;
                
                mask[node] = true;
                dfs(isConnected, node, mask);
            }
        }
        
        return answer;
    }
    
    private void dfs(int[][] isConnected, int node, boolean[] mask) {
        for (int nextNode = 0; nextNode < isConnected.length; nextNode++) {
            if (mask[nextNode] == false && isConnected[node][nextNode] == 1) {
                mask[nextNode] = true;
                dfs(isConnected, nextNode, mask);
            }
        }
    }
}