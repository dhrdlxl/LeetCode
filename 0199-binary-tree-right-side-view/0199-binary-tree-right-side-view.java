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
    private int height = 0;
    private List<Integer> answer;
    
    public List<Integer> rightSideView(TreeNode root) {
        answer = new LinkedList<>();
        
        dfs(root, 0);
        
        return answer;
    }
    
    private void dfs(TreeNode root, int h) {
        if (root == null) {
            return;
        }
        
        if (height == h) {
            answer.add(root.val);
            height++;
        }
        
        dfs(root.right, h + 1);
        dfs(root.left, h + 1);
    }
}