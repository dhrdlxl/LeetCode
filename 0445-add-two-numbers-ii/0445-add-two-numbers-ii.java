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
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode answer = null;
        while ((stack1.empty() && stack2.empty()) == false) {
            int sum = carry;
            if (!stack1.empty()) {
                sum += stack1.pop();
            }
            
            if (!stack2.empty()) {
                sum += stack2.pop();
            }
            
            answer = addNode(answer, sum % 10);
            
            carry = (sum / 10);
        }
        
        return carry == 0 ? answer : addNode(answer, carry);
    }
    
    private ListNode addNode(ListNode node, int val) {
        ListNode newNode = new ListNode();
        newNode.val = val;
        newNode.next = node;
        node = newNode;
        
        return node;
    }
}