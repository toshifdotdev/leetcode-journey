/**
 * Problem: Odd Even Linked List (#328)
 * Date: 25-07-2026
 *
 
 * Approach (Optimal - Pointer Manipulation)

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

    public ListNode oddEvenList(ListNode head) {

        // ---------------- Optimal Approach ----------------

        // Empty list or single node
        if (head == null || head.next == null)
            return head;

        // Pointer for odd-indexed nodes
        ListNode odd = head;

        // Pointer for even-indexed nodes
        ListNode even = head.next;

        // Store the head of even list so it can be
        // attached after the odd list
        ListNode evenHead = head.next;

        // Rearrange odd and even pointers
        while (even != null && even.next != null) {

            // Link current odd node to next odd node
            odd.next = odd.next.next;
            odd = odd.next;

            // Link current even node to next even node
            even.next = even.next.next;
            even = even.next;
        }

        // Attach even list after odd list
        odd.next = evenHead;

        return head;


        // ---------------- Brute Force Approach ----------------
        /*
        if (head == null || head.next == null)
            return head;

        List<Integer> li = new ArrayList<>();

        ListNode temp = head;

        // Store odd-indexed node values
        while (temp != null && temp.next != null) {
            li.add(temp.val);
            temp = temp.next.next;
        }

        if (temp != null) {
            li.add(temp.val);
        }

        // Store even-indexed node values
        temp = head.next;

        while (temp != null && temp.next != null) {
            li.add(temp.val);
            temp = temp.next.next;
        }

        // Copy values back into the linked list
        temp = head;
        int i = 0;

        while (temp != null && i < li.size()) {
            temp.val = li.get(i);
            i++;
            temp = temp.next;
        }

        return head;
        */
    }
}