/**
 * Problem: Remove Duplicates from a Sorted Doubly Linked List (GFG)
 * Date: 03-08-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - Two Pointers)
 * ------------------------------------------------------------

 *
 * Time Complexity:
 * O(n)
 * Every node is visited at most once.
 *
 * Space Complexity:
 * O(1)
 * Only pointer manipulation is used.
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

class Solution {

    Node removeDuplicates(Node headRef) {

        if (headRef == null)
            return headRef;

        Node temp = headRef;

        while (temp != null && temp.next != null) {

            // First node after temp
            Node nextNode = temp.next;

            // Skip all duplicate nodes
            while (nextNode != null && temp.data == nextNode.data) {
                nextNode = nextNode.next;
            }

            // Connect current node directly to
            // the next distinct node
            temp.next = nextNode;

            // Maintain backward pointer
            if (nextNode != null)
                nextNode.prev = temp;

            // Move to next distinct node
            temp = temp.next;
        }

        return headRef;
    }
}