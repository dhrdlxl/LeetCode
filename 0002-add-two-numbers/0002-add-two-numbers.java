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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curNode = head;
        int carry = 0;
        int sum = 0;
        
        while (l1 != null || l2 != null) {
            sum = 0;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            curNode.next = new ListNode((sum + carry) % 10);
            curNode = curNode.next;
            carry = (sum + carry) / 10;
        }
        
        if (carry > 0) {
            curNode.next = new ListNode(carry);
        }
        
        return head.next;
    }
}