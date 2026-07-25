/**
 * Problem: Linked List Cycle II (#142)
 * Date: 25-07-2026
 *
 * 
 * Approach (Optimal - Floyd's Cycle Detection Algorithm)
 
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 *
 * ------------------------------------------------------------
 *
 * Alternative Approach:

 * Time Complexity : O(n)
 * Space Complexity: O(n)
 *
 * ------------------------------------------------------------
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    public ListNode detectCycle(ListNode head) {

        // ---------------- Optimal Approach ----------------
        // Floyd's Cycle Detection Algorithm

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Find the collision point inside the cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // Collision detected
            if (slow == fast) {

                // Step 2:
                // Move slow back to head.
                // Move both pointers one step at a time.
                // Their meeting point will be the start of the cycle.
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        // No cycle exists
        return null;


        // ---------------- Brute Force Approach ----------------
        /*
        ListNode temp = head;

        HashMap<ListNode, Integer> hm = new HashMap<>();

        while (temp != null) {

            // Node already visited
            if (hm.containsKey(temp)) {
                return temp;
            }

            hm.put(temp, 1);

            temp = temp.next;
        }

        return null;
        */
    }
}