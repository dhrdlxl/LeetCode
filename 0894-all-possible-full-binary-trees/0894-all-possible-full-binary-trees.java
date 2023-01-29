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
    HashMap<Integer, List<TreeNode>> cache = new HashMap();
    
    public List<TreeNode> allPossibleFBT(int n) {
        if (!cache.containsKey(n)) {
            List<TreeNode> answer = new LinkedList<>();
            
            if (n == 1) {
                answer.add(new TreeNode(0));
            }
            else if (n % 2 == 1) {
                for (int x = 1; x < n; x += 2) {
                    int y = n - 1 - x;
                    
                    for (TreeNode left : allPossibleFBT(x)) {
                        for (TreeNode right : allPossibleFBT(y)) {
                            TreeNode newRoot = new TreeNode(0);
                            newRoot.left = left;
                            newRoot.right = right;
                            answer.add(newRoot);
                        }
                    }
                }
            }
            
            cache.put(n, answer);
        }
        
        return cache.get(n);
    }
}