/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    private HashSet<Integer> set;

    public FindElements(TreeNode root) {
        set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        root.val = 0;
        q.add(root);
        set.add(root.val);
        
        while (!q.isEmpty()) {
            TreeNode curNode = q.remove();
            int val = 0;
            
            if (Objects.nonNull(curNode.left)) {
                val = curNode.val * 2 + 1;
                curNode.left.val = val;
                q.add(curNode.left);
                set.add(val);
            }
            if (Objects.nonNull(curNode.right)) {
                val = curNode.val * 2 + 2;
                curNode.right.val = val;
                q.add(curNode.right);
                set.add(val);
            }
        }
        
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */