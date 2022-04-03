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
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        StringBuilder sb = new StringBuilder();
        
        while (head != null) {
            sb.append(head.val);
            len++;
            
            head = head.next;
        }
        
        String left = sb.substring(0, len / 2);
        String right = sb.reverse().substring(0, len / 2);
        
        return left.equals(right) ? true : false;
    }
}