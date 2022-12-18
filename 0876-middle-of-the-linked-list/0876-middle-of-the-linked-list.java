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
    public ListNode middleNode(ListNode head) {
        int count = 1;
        ListNode node = head;
        ListNode answer = head;
        
        while (node != null) {
            node = node.next;

            if (count % 2 == 0) {
                answer = answer.next;
            }

            count++;
        }
        
        return answer;
    }
}