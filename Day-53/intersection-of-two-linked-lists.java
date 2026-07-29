/**
 * Problem: Intersection of Two Linked Lists (#160)
 * Date: 29-07-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - Two Pointers)
 * ------------------------------------------------------------

 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(n + m)
 *
 * Space Complexity:
 * O(1)
 *
 * ------------------------------------------------------------
 *
 * Alternative Approaches:
 *
 * 1. Better:
 *    - Find the lengths of both linked lists.
 *    - Move the pointer of the longer list ahead by
 *      the difference in lengths.
 *    - Traverse both lists together until they meet.
 *
 *    Time  : O(n + m)
 *    Space : O(1)
 *
 * 2. Brute Force:
 *    - Store every node of the first list in a HashMap.
 *    - Traverse the second list and return the first
 *      node already present in the map.
 *
 *    Time  : O(n + m)
 *    Space : O(n)
 *
 * ------------------------------------------------------------
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    // ---------------- Better Approach ----------------
    // Moves the longer list ahead by the difference
    // in lengths and finds the collision point.
    private ListNode collisionPoint(ListNode temp1, ListNode temp2, int d) {

        // Move the pointer of the longer list
        // ahead by 'd' nodes.
        for (int i = 0; i < d; i++) {
            temp2 = temp2.next;
        }

        // Move both pointers together
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // ---------------- Optimal Approach ----------------

        if (headA == null || headB == null)
            return null;

        ListNode t1 = headA;
        ListNode t2 = headB;

        // Traverse both lists
        while (t1 != t2) {

            t1 = t1.next;
            t2 = t2.next;

            // If both meet, return the intersection node
            if (t1 == t2)
                return t1;

            // Redirect pointers after reaching the end
            if (t1 == null)
                t1 = headB;

            if (t2 == null)
                t2 = headA;
        }

        return t1;


        // ---------------- Better Approach ----------------
        /*
        int n1 = 0;
        int n2 = 0;

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        // Find lengths of both linked lists
        while (temp1 != null) {
            n1++;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            n2++;
            temp2 = temp2.next;
        }

        temp1 = headA;
        temp2 = headB;

        if (n1 < n2)
            return collisionPoint(temp1, temp2, n2 - n1);
        else
            return collisionPoint(temp2, temp1, n1 - n2);
        */


        // ---------------- Brute Force Approach ----------------
        /*
        HashMap<ListNode, Integer> hm = new HashMap<>();

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        // Store all nodes of the first list
        while (temp1 != null) {
            hm.put(temp1, 1);
            temp1 = temp1.next;
        }

        // Find the first common node
        while (temp2 != null) {

            if (hm.containsKey(temp2))
                break;

            temp2 = temp2.next;
        }

        if (temp2 == null)
            return null;

        return temp2;
        */
    }
}