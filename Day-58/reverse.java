/**
 * Problem: Reverse Nodes in k-Group (#25)
 * Date: 04-08-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - Reverse Each Group of K Nodes)
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N)

 * Space Complexity:
 * O(k)
 * (Recursive reverse uses recursion stack of at most k nodes.)
 *
 * ------------------------------------------------------------
 *
 * Alternative Approach:
 * Reverse each group iteratively using three pointers.
 * This reduces recursion stack usage to O(1).
 *
 * ------------------------------------------------------------
 */

class Solution {

    // Reverse the current group recursively
    private ListNode reverse(ListNode head) {

        if (head.next == null)
            return head;

        ListNode newHead = reverse(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    // Find the kth node starting from temp
    private ListNode findKthNode(ListNode temp, int k) {

        int cnt = 0;

        while (temp != null) {

            cnt++;

            if (cnt == k)
                break;

            temp = temp.next;
        }

        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevNode = null;
        ListNode nextNode = null;

        while (temp != null) {

            // Find kth node of current group
            ListNode KthNode = findKthNode(temp, k);

            // Remaining nodes are less than k
            if (KthNode == null) {

                if (prevNode != null)
                    prevNode.next = nextNode;

                break;
            }

            // Store the next group's starting node
            nextNode = KthNode.next;

            // Separate current group
            KthNode.next = null;

            // Reverse current group
            ListNode newHead = reverse(temp);

            // Update head for the first group
            if (temp == head) {
                head = KthNode;
            }
            else {
                prevNode.next = KthNode;
            }

            // Move to next group
            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }
}