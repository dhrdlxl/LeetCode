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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean answer = false;
        
        if (root == null)
            return false;
        
        if (root.val == subRoot.val) {
            answer = answer | isSame(root, subRoot);
            if (answer == true)
                return true;
        }
        
        if (root.right != null)
            answer = answer | isSubtree(root.right, subRoot);
        if (root.left != null)
            answer = answer | isSubtree(root.left, subRoot);

        return answer;
    }
    
    private boolean isSame(TreeNode root, TreeNode subRoot) {
        boolean answer = true;
        
        if ((root == null && subRoot != null) || (root != null && subRoot == null))
            return false;

        if (root.val == subRoot.val) {
            if (root.left != null || subRoot.left != null)
                answer = answer & isSame(root.left, subRoot.left);
            if (root.right != null || subRoot.right != null)
                answer = answer & isSame(root.right, subRoot.right);
        } else {
            return false;
        }
        
        return answer;
    }
}