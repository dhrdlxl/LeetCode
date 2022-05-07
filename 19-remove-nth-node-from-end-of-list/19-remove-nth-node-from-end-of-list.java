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
        ListNode start = new ListNode(0);
        ListNode slow = start;
        ListNode fast = start;
        start.next = head;

        while (fast != null) {
            if (n < 0) {
                slow = slow.next;
            }
            
            fast = fast.next;
            n--;
        }
        
        slow.next = slow.next.next;
        
        return start.next;
    }
}