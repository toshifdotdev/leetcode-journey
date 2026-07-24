/**
 * Problem: Reverse Linked List (#206)
 * Date: 24-07-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - Recursive)
 * ------------------------------------------------------------
 *
 * Observation:
 * - Reverse the linked list recursively by first reversing
 *   the remaining list.
 * - Once the recursive call returns, make the next node point
 *   back to the current node.
 * - Break the original forward link to avoid creating a cycle.
 * - The new head of the reversed list is returned from the
 *   deepest recursive call.
 *
 * Example:
 *
 * Input:
 * 1 -> 2 -> 3 -> 4 -> 5
 *
 * Recursive Calls:
 * reverse(1)
 *   reverse(2)
 *     reverse(3)
 *       reverse(4)
 *         reverse(5)
 *
 * Backtracking:
 * 5 -> 4
 * 5 -> 4 -> 3
 * 5 -> 4 -> 3 -> 2
 * 5 -> 4 -> 3 -> 2 -> 1
 *
 * Output:
 * 5 -> 4 -> 3 -> 2 -> 1
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 * (Recursion stack)
 *
 * ------------------------------------------------------------
 *
 * Alternative Approaches:
 *
 * 1. Iterative (Optimal)
 *    - Time : O(n)
 *    - Space: O(1)
 *
 * 2. Stack (Brute Force)
 *    - Time : O(n)
 *    - Space: O(n)
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

    public ListNode reverseList(ListNode head) {

        // ---------------- Recursive Approach ----------------

        // Base case:
        // If the list is empty or has only one node,
        // it is already reversed.
        if (head == null || head.next == null)
            return head;

        // Reverse the remaining list
        ListNode newHead = reverseList(head.next);

        // Current node's next node
        ListNode front = head.next;

        // Reverse the link
        front.next = head;

        // Break the original link
        head.next = null;

        // Return the new head of the reversed list
        return newHead;

        // ---------------- Iterative Approach ----------------
        /*
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {

            ListNode front = temp.next;

            temp.next = prev;

            prev = temp;

            temp = front;
        }

        return prev;
        */

        // ---------------- Brute Force (Stack) ----------------
        /*
        Deque<Integer> stack = new ArrayDeque<>();

        ListNode temp = head;

        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            temp.val = stack.pop();
            temp = temp.next;
        }

        return head;
        */
    }
}