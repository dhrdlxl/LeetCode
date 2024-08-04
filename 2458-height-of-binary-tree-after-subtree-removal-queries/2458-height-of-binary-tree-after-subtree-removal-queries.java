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
    private Map<Integer, Integer> leftMaxHeight = new HashMap<>();
    private Map<Integer, Integer> rightMaxHeight = new HashMap<>();
    private Map<Integer, Integer> removedMaxHeight = new HashMap<>();
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] answer = new int[queries.length];
        
        getMaxHeight(root, 0);
        getMaxHeightWhenRemoved(root, 0);
         
        for (int i = 0; i < queries.length; i++) {
            answer[i] = removedMaxHeight.get(queries[i]);
        }
        
        return answer;
    }
    
    private int getMaxHeight(TreeNode node, int height) {
        if (node == null) {
            return height - 1;
        }
        
        int val = node.val;
        leftMaxHeight.put(val, getMaxHeight(node.left, height + 1));
        rightMaxHeight.put(val, getMaxHeight(node.right, height + 1));
        
        return Math.max(leftMaxHeight.get(val), rightMaxHeight.get(val));
    }
    
    private void getMaxHeightWhenRemoved(TreeNode node, int curHeight) {
        if (node == null) {
            return;
        }
        
        removedMaxHeight.put(node.val, curHeight);
        
        getMaxHeightWhenRemoved(node.left, Math.max(curHeight, rightMaxHeight.get(node.val)));
        getMaxHeightWhenRemoved(node.right, Math.max(curHeight, leftMaxHeight.get(node.val)));
    }
}