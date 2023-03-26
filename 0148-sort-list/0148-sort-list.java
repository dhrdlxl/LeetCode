/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        return merge(left, right);
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode m = new ListNode(0);
        ListNode mergeNode = m;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                mergeNode.next = left;
                left = left.next;
            } else {
                mergeNode.next = right;
                right = right.next;
            }
            
            mergeNode = mergeNode.next;
        }
        
        if (left != null) {
            mergeNode.next = left;
        } else if (right != null) {
            mergeNode.next = right;
        }
        
        return m.next;
    }
}