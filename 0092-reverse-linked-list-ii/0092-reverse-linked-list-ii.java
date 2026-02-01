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
    private int index;
    private ListNode rightPeekNode;
    private ListNode leftPeekNode;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        index++;

        if (index == right) {
            rightPeekNode = head.next;

            if (leftPeekNode != null)
                leftPeekNode.next = head;
                
        } else if (left < index && index < right) {
            ListNode rangeRightNode = reverseBetween(head.next, left, right);
            head.next.next = head;
            return rangeRightNode;
        } else if (index == left) {
            ListNode rangeRightNode = reverseBetween(head.next, left, right);
            head.next.next = head;
            head.next = rightPeekNode;
            return rangeRightNode;
        } else if (index == left - 1) {
            leftPeekNode = head;
            reverseBetween(head.next, left, right);
        } else {
            reverseBetween(head.next, left, right);
        }

        return head;
    }
}