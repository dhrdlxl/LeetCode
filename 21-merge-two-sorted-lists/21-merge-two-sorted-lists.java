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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode answer = new ListNode();
        
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null && list2 != null) {
            answer.val = list2.val;
            answer.next = mergeTwoLists(null, list2.next);
            
        } else if (list1 != null && list2 == null) {
            answer.val = list1.val;
            answer.next = mergeTwoLists(list1.next, null);
        } else {
            if (list1.val < list2.val) {
                answer.val = list1.val;
                answer.next = mergeTwoLists(list1.next, list2);
            } else {
                answer.val = list2.val;
                answer.next = mergeTwoLists(list1, list2.next);
            }
        }
        return answer;
    }
}