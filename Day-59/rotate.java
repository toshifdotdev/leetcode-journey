/**
 * Problem: Rotate List (#61)
 * Date: 05-08-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - Circular Linked List)
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(2N)
 * 
 * Space Complexity:
 * O(1)
 *
 * ------------------------------------------------------------
 *
 * Alternative Approach:
 * - Rotate the list one position at a time for k rotations.
 *
 * Time Complexity : O(N × K)
 * Space Complexity: O(1)
 *
 * ------------------------------------------------------------
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    // Finds the nth node (1-based indexing)
    private ListNode findNthNode(ListNode head, int newTailIndi) {

        ListNode temp = head;

        while (temp != null) {

            newTailIndi--;

            if (newTailIndi == 0)
                break;

            temp = temp.next;
        }

        return temp;
    }

    public ListNode rotateRight(ListNode head, int k) {

        // Empty list or single node
        if (head == null || head.next == null)
            return head;

        // Find the length and the last node
        ListNode tail = head;
        int len = 1;

        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        // No rotation needed
        if (k % len == 0)
            return head;

        // Effective rotations
        k = k % len;

        // Find the new tail
        ListNode newTail = findNthNode(head, len - k);

        // Make the list circular
        tail.next = head;

        // New head is next of new tail
        head = newTail.next;

        // Break the circular link
        newTail.next = null;

        return head;
    }
}