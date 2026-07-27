/**
 * Problem: Remove Nth Node From End of List (#19)
 * Date: 27-07-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - Two Pointers)
 * ------------------------------------------------------------
 *
 * Output:
 * 1 -> 2 -> 3 -> 5
 *
 * ------------------------------------------------------------
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
 * 1. Count the total number of nodes.
 * 2. Find the (length - n)th node.
 * 3. Delete the next node.
 *
 * Time Complexity : O(n)
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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // ---------------- Optimal Approach ----------------

        // If only one node exists, removing it leaves an empty list.
        if (head == null || head.next == null)
            return null;

        ListNode fast = head;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast becomes null, the head node needs to be removed
        if (fast == null) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
            return head;
        }

        ListNode slow = head;

        // Move both pointers until fast reaches the last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Delete the required node
        ListNode delNode = slow.next;
        slow.next = slow.next.next;
        delNode.next = null;

        return head;


        // ---------------- Brute Force Approach ----------------
        /*
        if (head == null || head.next == null)
            return null;

        ListNode temp = head;
        int cnt = 0;

        // Count total number of nodes
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // If the head node needs to be deleted
        if (cnt == n) {
            return head.next;
        }

        int stop = cnt - n;

        temp = head;

        // Reach the node just before the one to delete
        while (temp != null) {
            stop--;

            if (stop == 0)
                break;

            temp = temp.next;
        }

        // Delete the node
        ListNode front = temp.next;
        temp.next = front.next;
        front.next = null;

        return head;
        */
    }
}