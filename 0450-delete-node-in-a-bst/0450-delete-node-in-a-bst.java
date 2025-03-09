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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left != null && root.right != null) {
                TreeNode child = root.right;

                while (child.left != null) {
                    child = child.left;
                }
                root.val = child.val;
                root.right = deleteNode(root.right, child.val);
                return root;
            } else if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null) {
                return root.left;
            } else if (root.right != null) {
                return root.right;
            }
        }

        return root;
    }
}