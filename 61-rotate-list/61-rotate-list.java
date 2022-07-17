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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        
        //1. k값 구하기
        int nodeLength = 0;
        ListNode copyHead = head;
        
        while (copyHead != null) {
            nodeLength++;
            copyHead = copyHead.next;
        }
        
        k = k % nodeLength;
        
        if (k == 0)
            return head;
        
        
        //2. newEnd 찾기
        ListNode newEnd = head;
        
        for (int i = 0; i < nodeLength - 1 - k; i++) {
            newEnd = newEnd.next;
        }
        
        ListNode newHead = newEnd.next; // newHead
        newEnd.next = null;
        
        
        //3. newHead 덩어리 뒤에 기존 head 붙이기
        ListNode originHead = newHead;
        
        while (originHead.next != null) {
            originHead = originHead.next;// 기존 endNode
        }
        
        originHead.next = head;
        
        
        return newHead;
    }
}