/**
 * Problem: Sort List (#148)
 * Date: 28-07-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - Merge Sort on Linked List)
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(n log n)
 *
 * Space Complexity:
 * O(log n)
 * (Recursive call stack)
 
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

    // Merges two sorted linked lists
    private ListNode merge(ListNode head1, ListNode head2) {

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        ListNode t1 = head1;
        ListNode t2 = head2;

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

        // Attach remaining nodes
        if (t1 != null) {
            temp.next = t1;
        } else {
            temp.next = t2;
        }

        return dummyNode.next;
    }

    // Finds the middle node of the linked list
    private ListNode findMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode sortList(ListNode head) {

        // ---------------- Optimal Approach ----------------

        // Base case
        if (head == null || head.next == null)
            return head;

        // Find middle node
        ListNode mid = findMid(head);

        // Split the linked list into two halves
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;

        // Recursively sort both halves
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        // Merge the sorted halves
        return merge(leftHead, rightHead);


        // ---------------- Brute Force Approach ----------------
        /*
        ListNode temp = head;
        List<Integer> al = new ArrayList<>();

        // Store all node values
        while (temp != null) {
            al.add(temp.val);
            temp = temp.next;
        }

        // Sort the values
        Collections.sort(al);

        // Copy sorted values back to the list
        temp = head;
        int i = 0;

        while (temp != null) {
            temp.val = al.get(i++);
            temp = temp.next;
        }

        return head;
        */
    }
}