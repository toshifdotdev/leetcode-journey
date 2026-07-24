/**
 * Problem: Middle of the Linked List (#876)
 * Date: 24-07-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - Tortoise and Hare Algorithm)
 * ------------------------------------------------------------
 *
 * Observation:
 * - Use two pointers:
 *   1. Slow pointer moves one step at a time.
 *   2. Fast pointer moves two steps at a time.
 * - When the fast pointer reaches the end of the list,
 *   the slow pointer will be at the middle node.
 * - If the list contains two middle nodes (even length),
 *   return the second middle node as required.
 *
 * Example:
 *
 * Input:
 * 1 -> 2 -> 3 -> 4 -> 5
 *
 * Slow : 1 → 2 → 3
 * Fast : 1 → 3 → 5
 *
 * Output:
 * 3
 *
 * Example:
 *
 * Input:
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6
 *
 * Slow : 1 → 2 → 3 → 4
 * Fast : 1 → 3 → 5 → null
 *
 * Output:
 * 4
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
 * 2. Traverse again until (length / 2 + 1)-th node.
 * 3. Return that node.
 *
 * Time  : O(n)
 * Space : O(1)
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

    public ListNode middleNode(ListNode head) {

        // ---------------- Optimal Approach ----------------
        // Tortoise and Hare Algorithm

        ListNode slow = head;
        ListNode fast = head;

        // Move slow by one step and fast by two steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow pointer now points to the middle node
        return slow;


        // ---------------- Brute Force Approach ----------------
        /*
        ListNode temp = head;
        int cnt = 0;
        int len = 0;

        // Count total number of nodes
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        temp = head;

        // Traverse to the middle node
        while (temp != null) {
            cnt++;

            if (cnt == (len / 2 + 1))
                break;

            temp = temp.next;
        }

        return temp;
        */
    }
}