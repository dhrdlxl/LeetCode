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
    public String tree2str(TreeNode root) {
        String answer = Integer.toString(root.val);
        
        if (root.left != null) {
            answer += ("(" + tree2str(root.left) + ")");
            if (root.right != null) {
                answer += ("(" + tree2str(root.right) + ")");
            }
        } else if (root.left == null && root.right != null){
            answer += ("()(" + tree2str(root.right) + ")");
        }
        
        
        return answer;
    }
}