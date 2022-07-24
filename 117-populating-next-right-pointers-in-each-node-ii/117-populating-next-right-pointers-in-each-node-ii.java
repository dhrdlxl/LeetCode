/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        
        Queue<Node> q = new LinkedList<>();
        
        q.offer(root);
        while (!q.isEmpty()) {
            Node nextNode = null;// null
            Queue<Node> childNodes = new LinkedList<>();
            
            while(!q.isEmpty()) {
                Node curNode = q.poll();
                curNode.next = nextNode;
                nextNode = curNode;
                
                if (curNode.right != null ){
                    childNodes.offer(curNode.right);
                }
                if (curNode.left != null) {
                    childNodes.offer(curNode.left);
                }
            }
            
            while(!childNodes.isEmpty())
                q.offer(childNodes.poll());
        }
        
        return root;
    }
}