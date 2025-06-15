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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;

        if (root == null) {
            return answer;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> siblings = new LinkedList<>(); 
            int n = queue.size();

            while (0 < n--) {
                TreeNode curNode = queue.remove();
                siblings.add(curNode.val);
                
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

            if (level % 2 == 1) {
                Collections.reverse(siblings);
            }

            answer.add(siblings);
            level++;
        }

        return answer;
    }
}