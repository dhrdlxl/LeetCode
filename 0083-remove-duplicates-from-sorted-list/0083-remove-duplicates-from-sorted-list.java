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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;
        newHead.val = head.val;
        
        while (head.next != null) {
            int curVal = head.val;
            int nextVal = head.next.val;
            
            if (curVal != nextVal) {
                newTail.next = new ListNode();
                newTail = newTail.next;
                newTail.val = nextVal;
            }
            
            head = head.next;
        }
        
        return newHead;
    }
}