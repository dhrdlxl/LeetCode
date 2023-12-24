class Solution {
    private Map<Integer, List<Integer>> tree;
    private int[] xor;
    private List<Set<Integer>> childs;
    
    public int minimumScore(int[] nums, int[][] edges) {
        int answer = Integer.MAX_VALUE;
        tree = new HashMap<>();
        xor = new int[nums.length];
        childs = new ArrayList<Set<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            childs.add(new HashSet<>());
        }
        
        for (int[] edge : edges) {
            if (!tree.containsKey(edge[0])) {
                tree.put(edge[0], new LinkedList<>());
            }
            if (!tree.containsKey(edge[1])) {
                tree.put(edge[1], new LinkedList<>());
            }
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        dfs(0, -1, nums);
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int xor1 = 0;
                int xor2 = 0;
                int xor3 = 0;
                if (childs.get(i).contains(j)) {
                    xor1 = xor[0] ^ xor[i];
                    xor2 = xor[i] ^ xor[j];
                    xor3 = xor[j];
                } else if (childs.get(j).contains(i)) {
                    xor1 = xor[0] ^ xor[j];
                    xor2 = xor[j] ^ xor[i];
                    xor3 = xor[i];
                } else {
                    xor1 = xor[0] ^ xor[i] ^ xor[j];
                    xor2 = xor[i];
                    xor3 = xor[j];
                }
                
                answer = Math.min(answer, Math.max(xor1, Math.max(xor2, xor3)) - Math.min(xor1, Math.min(xor2, xor3)));
            }
        }
        
        return answer;
    }
    
    private int dfs(int curNode, int prevNode, int[] nums) {
        int xorValue = nums[curNode];
        childs.get(curNode).add(curNode);
        
        for (int nextNode : tree.get(curNode)) {
            if (prevNode != nextNode) {
                xorValue ^= dfs(nextNode, curNode, nums);
                childs.get(curNode).addAll(childs.get(nextNode));
            }
        }
        
        xor[curNode] = xorValue;
        return xorValue;
    }
}