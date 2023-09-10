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
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        dfs(root, 0, answer);
        
        return answer;
    }
    
    private void dfs(TreeNode root, int height, List<Integer> answer) {
        if (root == null) {
            return;
        }
        
        if (height + 1 > answer.size()) {
            answer.add(root.val);
        } else {
            answer.set(height, Math.max(answer.get(height), root.val));
        }
        
        dfs(root.left, height + 1, answer);
        dfs(root.right, height + 1, answer);
    }
}