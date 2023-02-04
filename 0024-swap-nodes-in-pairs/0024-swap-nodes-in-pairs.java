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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode before = null;
        ListNode left = head;
        ListNode right = head.next;
        head = right;
        
        while (left != null && right != null) {
            ListNode next = right.next;
            right.next = left;
            left.next = next;
            
            if (before != null) {
                before.next = right;
            }
            
            before = left;
            
            left = next;
            if (left == null) {
                break;
            }
            right = next.next;
        }
        
        return head;
    }
}