/**
 * Problem: Add Two Numbers (#2)
 * Date: 24-07-2026
 *
 * Approach (Optimal - Linked List Simulation)

 *
 * Example:
 *
 * l1 = 2 -> 4 -> 3
 * l2 = 5 -> 6 -> 4
 *
 * Step 1:
 * 2 + 5 = 7
 * Answer: 7
 *
 * Step 2:
 * 4 + 6 = 10
 * Store 0
 * Carry = 1
 *
 * Step 3:
 * 3 + 4 + 1 = 8
 *
 * Result:
 * 7 -> 0 -> 8
 *
 * Represents:
 * 807
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(max(n, m))
 *
 * Space Complexity:
 * O(max(n, m))
 * (Result linked list)
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to simplify list construction
        ListNode dummyNode = new ListNode(-1);

        // Pointers for traversing both linked lists
        ListNode head1 = l1;
        ListNode head2 = l2;

        // Pointer to build the answer list
        ListNode current = dummyNode;

        int carry = 0;
        int sum = 0;

        // Traverse until both lists are completely processed
        while (head1 != null || head2 != null) {

            // Start with the carry from the previous addition
            sum = carry;

            // Add current digit from first list
            if (head1 != null)
                sum += head1.val;

            // Add current digit from second list
            if (head2 != null)
                sum += head2.val;

            // Store only the unit digit in the new node
            // Example:
            // sum = 18
            // Store = 8
            ListNode newNode = new ListNode(sum % 10);

            // Update carry
            carry = sum / 10;

            // Attach new node to the answer list
            current.next = newNode;
            current = newNode;

            // Move to the next node in both lists
            if (head1 != null)
                head1 = head1.next;

            if (head2 != null)
                head2 = head2.next;
        }

        // If carry still remains, create one final node
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
        }

        // Return the actual head (skip dummy node)
        return dummyNode.next;
    }
}