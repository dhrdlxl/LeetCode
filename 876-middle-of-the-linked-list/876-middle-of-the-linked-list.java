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
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        
        count /= 2;
        ListNode answer = head;
        int index = 0;
        
        
        while (answer != null) {
            if (index == count) {
                return answer;
            }
            answer = answer.next;
            index++;
        }
        
        return answer;
    }
}