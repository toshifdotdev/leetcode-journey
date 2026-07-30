/**
 * Problem: Remove Linked List Elements (#203)
 * Date: 30-07-2026
 *
 * ------------------------------------------------------------
 * Approach (Iterative - Pointer Manipulation)
 * ------------------------------------------------------------

 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 *
 
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

    // Deletes the node immediately after 'prev'
    private ListNode delNode(ListNode prev) {

        ListNode temp = prev.next;

        prev.next = temp.next;

        temp.next = null;

        return prev;
    }

    public ListNode removeElements(ListNode head, int val) {

        // Empty linked list
        if (head == null)
            return null;

        // Current node starts from second node
        ListNode temp = head.next;

        // Previous node starts from head
        ListNode prev = head;

        // Traverse the linked list
        while (temp != null) {

            // Delete current node if value matches
            if (temp.val == val) {

                prev = delNode(prev);

                temp = prev.next;

            } else {

                temp = temp.next;
                prev = prev.next;
            }
        }

        // Handle the case where head itself
        // needs to be removed
        if (head.val == val) {
            return head.next;
        }

        return head;
    }
}