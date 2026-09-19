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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            // Store the next node
            next = curr.next;
            // Reverse the link
            curr.next = prev;
            // Move prev
            prev = curr;
            // Move curr
            curr = next;
        }
        return prev;
    }
}
