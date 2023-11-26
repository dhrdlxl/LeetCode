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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        ListNode secondStart = head.next;
        
        while (firstNode != null && secondNode != null) {
            if (secondNode.next != null) {
                firstNode.next = secondNode.next;
                firstNode = firstNode.next;
                
                if (firstNode.next != null) {
                    secondNode.next = firstNode.next;
                    secondNode = secondNode.next;
                } else {
                    secondNode.next = null;
                    break;
                }
            } else {
                firstNode.next = null;
                break;
            }
        }
        
        firstNode.next = secondStart;

        return head;
    }
}