class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combine(int n, int k) {
        answer = new ArrayList<>();
        
        dfs(n, k, 1, new LinkedList<>());
        
        return answer;
    }
    
    private void dfs(int n, int k, int start, LinkedList<Integer> numList) {
        if (k == 0) {
            answer.add((List)numList.clone());
            return;
        }
        
        for (int i = start; i <= n; i++) {
            numList.offer(i);
            dfs(n, k - 1, i + 1, numList);
            numList.removeLast();
        }
    }
}