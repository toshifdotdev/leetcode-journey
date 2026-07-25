/**
 * Problem: Linked List Cycle (#141)
 * Date: 25-07-2026
 *
 * Approach (Optimal - Tortoise and Hare Algorithm)

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
 * Use a HashMap (or HashSet) to store visited nodes.
 * If a node is visited again, a cycle exists.
 *
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

    public boolean hasCycle(ListNode head) {

        // ---------------- Optimal Approach ----------------
        // Tortoise and Hare Algorithm

        ListNode slow = head;
        ListNode fast = head;

        // Move slow by one step and fast by two steps
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // If both pointers meet, a cycle exists
            if (fast == slow)
                return true;
        }

        // Fast pointer reached the end
        // No cycle exists
        return false;


        // ---------------- Brute Force Approach ----------------
        /*
        ListNode temp = head;

        HashMap<ListNode, Integer> hm = new HashMap<>();

        while (temp != null) {

            // Node already visited
            if (hm.containsKey(temp)) {
                return true;
            }

            hm.put(temp, hm.getOrDefault(temp, 0) + 1);

            temp = temp.next;
        }

        return false;
        */
    }
}