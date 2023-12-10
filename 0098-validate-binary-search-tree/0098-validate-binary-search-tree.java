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
    private Long min = Long.MIN_VALUE;
    
    public boolean isValidBST(TreeNode root) {
        
        // left
        if (root.left != null) {
            if (isValidBST(root.left) == false) {
                return false;
            }
        }
        
        // root
        if (min < root.val) {
            min = Long.valueOf(root.val);
        } else {
            return false;
        }
        
        // right
        if (root.right != null) {
            if (isValidBST(root.right) == false) {
                return false;
            }
        }
        
        return true;
    }
}