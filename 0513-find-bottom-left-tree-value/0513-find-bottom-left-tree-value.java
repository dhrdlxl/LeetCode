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
    private int answer = 0;
    private int maxH = -1;

    public int findBottomLeftValue(TreeNode root) {
        find(root, 0);

        return answer;
    }

    private void find(TreeNode root, int h) {
        if (root.left != null) {
            find(root.left, h + 1);
        }
        if (root.right != null) {
            find(root.right, h + 1);
        }

        if (maxH < h) {
            maxH = h;
            answer = root.val;
        }
    }
}