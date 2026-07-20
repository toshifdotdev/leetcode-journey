// Problem: Delete Node in a Linked List (#237)
// Date: 20-07-2026

// ------------------------------------------------------------
// Approach (Optimal - In-place Node Modification)
// ------------------------------------------------------------
//
// Time Complexity:
// O(1)
//
// Space Complexity:
// O(1)
// ------------------------------------------------------------

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public void deleteNode(ListNode node) {

        // Copy the next node's value into the current node
        node.val = node.next.val;

        // Skip the next node
        node.next = node.next.next;
    }
}