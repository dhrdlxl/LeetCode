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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] answer = new int[]{Integer.MAX_VALUE, -1};
        int index = 1;
        int before = head.val;
        int minCriticalPoint = -1;
        int maxCriticalPoint = -1;
        int beforeCriticalPoint = -1;

        while (head.next != null) {
            int cur = head.val;
            int next = head.next.val;

            if ((cur < before && cur < next) || (cur > before && cur > next)) {
                if (minCriticalPoint == -1) {
                    minCriticalPoint = index;
                }

                beforeCriticalPoint = maxCriticalPoint;
                maxCriticalPoint = index;

                if (beforeCriticalPoint > 0 && maxCriticalPoint > 0) {
                    answer[0] = Math.min(answer[0], maxCriticalPoint - beforeCriticalPoint);
                }
            }

            before = head.val;
            head = head.next;
            index++;
        }

        if (answer[0] == Integer.MAX_VALUE) {
            answer[0] = -1;
        }

        if (minCriticalPoint > 0 && minCriticalPoint != maxCriticalPoint) {
            answer[1] = (maxCriticalPoint - minCriticalPoint);
        }
        
        return answer;
    }
}