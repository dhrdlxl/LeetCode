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
class BSTIterator {
    private TreeNode root;
    
    public BSTIterator(TreeNode root) {
        this.root = root;
    }
    
    public int next() {
        TreeNode node = root;
        Stack<TreeNode> treeStack = new Stack<>();
        int nextVal = 0;
        
        treeStack.push(node);
        //가장 작은 노드 찾기
        while (node.left != null) {
            node = node.left;
            treeStack.push(node);
        }
        
        nextVal = node.val;
        
        //delete
        //root 노드가 가장 작은 경우(왼쪽 자식 노드가 없음)
        if (treeStack.size() == 1) {
            if (root.right != null) {
                root = root.right; //오른쪽 노드로 root 교체
            } else {
                root = null;
            }
            
        } else { // root 왼쪽 자식 노드가 있는 경우.
            treeStack.pop();
            TreeNode parentNode = treeStack.peek();
            
            if (node.right != null) { // 오른쪽 자식 노드가 있는 경우
                parentNode.left = node.right;
            } else {
                parentNode.left = null;
            }
        }
        
        return nextVal;
    }
    
    public boolean hasNext() {
        return root != null ? true : false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */