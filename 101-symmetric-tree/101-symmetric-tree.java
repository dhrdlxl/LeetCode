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

import java.util.*;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> leftTree = new LinkedList<>();
        Queue<TreeNode> rightTree = new LinkedList<>();
        
        leftTree.offer(root.left);
        rightTree.offer(root.right);
        
        while(!(leftTree.size() == 0 && rightTree.size() == 0)) {
            TreeNode leftTreeNode = leftTree.poll();
            TreeNode rightTreeNode = rightTree.poll();
            
            //1. 둘 다 null인 경우
            if (leftTreeNode == null && rightTreeNode == null) { 
                continue;
            } 
            // 2. 한쪽만 null인 경우
            else if ((leftTreeNode == null && rightTreeNode != null) || 
                (leftTreeNode != null && rightTreeNode == null)) { 
                return false;
            } 
            //3. 값이 다른 경우
            else if (leftTreeNode.val != rightTreeNode.val) { 
                return false;
            }
            
            
            leftTree.offer(leftTreeNode.left);
            leftTree.offer(leftTreeNode.right);
            rightTree.offer(rightTreeNode.right);
            rightTree.offer(rightTreeNode.left);
            
        }
        
        return true;
    }
}