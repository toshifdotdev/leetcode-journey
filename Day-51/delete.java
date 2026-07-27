/**
 * Problem: Delete the Middle Node of a Linked List (#2095)
 * Date: 27-07-2026
 *
 * Approach (Optimal - Tortoise and Hare Algorithm)

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
 * 2. Traverse to the node just before the middle.
 * 3. Delete the middle node.
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

    public ListNode deleteMiddle(ListNode head) {

        // ---------------- Optimal Approach ----------------

        if (head == null || head.next == null)
            return null;

        ListNode slow = head;

     
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode delNode = slow.next;
        slow.next = slow.next.next;
        delNode.next = null;

        return head;


        // ---------------- My Approach ----------------
        /*
        if (head == null || head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next.next != null &&
               fast.next.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode delNode = slow.next;
        slow.next = slow.next.next;
        delNode.next = null;

        return head;
        */
    }
}