/**
 * Problem: Merge Two Sorted Lists (#21)
 * Date: 28-07-2026
 *
 * Approach (Optimal - Iterative + Dummy Node)

 *
 * Time Complexity:
 * O(n + m)
 *
 * Space Complexity:
 * O(1)
 *
 * ------------------------------------------------------------

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node to simplify list construction
        ListNode dummyNode = new ListNode(-1);

        // Pointer used to build the merged list
        ListNode temp = dummyNode;

        // Traversal pointers
        ListNode t1 = list1;
        ListNode t2 = list2;

        // Compare nodes from both lists
        while (t1 != null && t2 != null) {

            if (t1.val <= t2.val) {

                temp.next = t1;
                temp = t1;
                t1 = t1.next;

            } else {

                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }

        // Attach the remaining nodes
        if (t1 != null) {
            temp.next = t1;
        } else {
            temp.next = t2;
        }

        // Return merged list (skip dummy node)
        return dummyNode.next;
    }
}