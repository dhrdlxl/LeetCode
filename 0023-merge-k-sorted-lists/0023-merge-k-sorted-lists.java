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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> numList = new ArrayList<>();
        
        for (ListNode node : lists) {
            while (node != null) {
                numList.add(node.val);
                node = node.next;
            }
        }
        
        numList.sort(Comparator.naturalOrder());
        
        ListNode head = new ListNode();
        ListNode node = head;
        
        for (int num : numList) {
            node.next = new ListNode(num);
            node = node.next;
        }
        
        return head.next;
    }
}