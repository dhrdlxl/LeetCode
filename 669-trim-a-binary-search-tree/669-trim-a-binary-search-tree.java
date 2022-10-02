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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        
        if (low <= root.val && root.val <= high) { //1. root가 범위 내부일 경우.
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        } else if (root.val < low) { //2. root가 범위보다 작을 경우
            //BST이므로 left, root 는 범위에 들어올 수 없음.
            return trimBST(root.right, low, high);
        } else if (high < root.val) { //3. root가 범위보다 클 경우
            //BST이므로 right, root는 범위에 들어올 수 없음.
            return trimBST(root.left, low, high);
        }
        
        return root;
    }
}