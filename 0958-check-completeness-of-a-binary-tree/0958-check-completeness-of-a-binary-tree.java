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
class Solution {
    private boolean isEnd = false;
    
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.remove();
            
            if (checkCompleteTree(curNode.left, queue) == false) {
                return false;
            }
            if (checkCompleteTree(curNode.right, queue) == false) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean checkCompleteTree(TreeNode node, Queue<TreeNode> queue) {
        if (node != null) {
            if (isEnd) {
                return false;
            }
            
            queue.add(node);
        } else {
            isEnd = true;
        }
        
        return true;
    }
}