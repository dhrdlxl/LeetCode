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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        int count = 0;
        while (start != null && count != k) {
            start = start.next;
            count++;
        }
        
        if (count == k) {
            start = reverseKGroup(start, k);
            
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = start;
                start = head;
                head = temp;
            }
            
            head = start;
        }
        
        return head;
    }
}