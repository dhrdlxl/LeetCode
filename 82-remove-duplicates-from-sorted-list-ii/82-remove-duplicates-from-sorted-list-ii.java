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
            return head;
        }
        
        ListNode newNode = head;
        ListNode nextNode = head;
        
        while (newNode != null && nextNode != null) {
            int count = 0;
            
            while(nextNode.next != null && nextNode.val == nextNode.next.val) {
                nextNode = nextNode.next;
                count++;
            }
            
            if (count == 0 && newNode.val != nextNode.val) {
                newNode.next = nextNode;
                newNode = nextNode;
            } else if (count > 0 && newNode.val == nextNode.val) {
                head = nextNode.next;
                newNode = head;
            }
            
            nextNode = nextNode.next;
        }
        
        if (newNode != null)
            newNode.next = null;
        
        return head;
    }
}