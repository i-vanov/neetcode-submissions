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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Use dummy in case we need to remove the head
        ListNode dummy = new ListNode(0, head);
        ListNode l = dummy;
        ListNode r = dummy;

        // Place the right node n nodes apart
        for (int i = 0; i < n; i++) {
            r = r.next;
        }
        // Go till the end, then l would be the node immediately before the n-th node from the end
        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        // Remove the node
        l.next = l.next.next;
        return dummy.next;
    }
}
