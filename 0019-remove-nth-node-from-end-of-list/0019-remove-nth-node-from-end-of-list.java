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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode left = start;
        ListNode right = start;
        
        while (n > 0) {
            n--;
            right = right.next;
        }
        
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        
        left.next = left.next.next;
        
        return start.next;
    }
}