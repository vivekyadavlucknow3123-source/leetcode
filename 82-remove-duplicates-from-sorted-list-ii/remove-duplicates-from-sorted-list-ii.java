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
        // Dummy node to handle edge cases where head itself is a duplicate
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy; // Last node in the guaranteed distinct list

        while (head != null) {
            // Check if head is the start of a duplicate sequence
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with the same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Connect prev to the node after the duplicate sequence
                prev.next = head.next;
            } else {
                // No duplicate for head; move prev forward
                prev = prev.next;
            }

            head = head.next;
        }

        return dummy.next;
    }
}