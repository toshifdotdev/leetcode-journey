/**
 * Problem: Palindrome Linked List (#234)
 * Date: 25-07-2026
 *
 *
 * Approach (Optimal - Reverse Second Half + Two Pointers)

 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 *
 * ------------------------------------------------------------
 *
 * Alternative Approach:

 *
 * Time Complexity : O(n)
 * Space Complexity: O(n)
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

    // Reverses a linked list and returns the new head
    private ListNode reverse(ListNode head) {

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {

            ListNode front = temp.next;

            temp.next = prev;

            prev = temp;

            temp = front;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {

        // Empty list or single node is always a palindrome
        if (head == null || head.next == null)
            return true;

        // ---------------- Optimal Approach ----------------

        ListNode slow = head;
        ListNode fast = head;

        // Find the middle of the linked list
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode newHead = reverse(slow.next);

        // Compare both halves
        ListNode first = head;
        ListNode second = newHead;

        while (second != null) {

            if (first.val != second.val) {

                // Restore original list before returning
                reverse(newHead);

                return false;
            }

            first = first.next;
            second = second.next;
        }

        // Restore original linked list
        reverse(newHead);

        return true;


        // ---------------- Brute Force Approach ----------------
        /*
        if (head == null || head.next == null)
            return true;

        Deque<Integer> stack = new ArrayDeque<>();

        ListNode temp = head;

        // Push all node values into the stack
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        // Compare values while traversing again
        while (temp != null) {

            if (temp.val != stack.pop())
                return false;

            temp = temp.next;
        }

        return true;
        */
    }
}