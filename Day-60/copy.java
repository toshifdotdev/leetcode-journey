/**
 * Problem: Copy List with Random Pointer (#138)
 * Date: 07-08-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - In-place Deep Copy)
 * ------------------------------------------------------------
 *
 * Observation:
 * - Instead of using a HashMap, insert a copy node
 *   immediately after every original node.
 * - This allows us to access the copy of any node
 *   using original.next.
 * - Set the random pointers of the copied nodes.
 * - Finally, separate the copied list from the
 *   original list while restoring the original list.
 *
 * Example:
 *
 * Original:
 *
 * 7 -> 13 -> 11 -> 10 -> 1
 * |     |      |       |
 * ↓     ↓      ↓       ↓
 * N     7      1      11
 *
 * Step 1:
 * Insert copied nodes:
 *
 * 7 -> 7' -> 13 -> 13' -> 11 -> 11' -> ...
 *
 * Step 2:
 * Set random pointers:
 *
 * copy.random = original.random.next
 *
 * Step 3:
 * Separate the two linked lists.
 *
 * Original:
 * 7 -> 13 -> 11 -> 10 -> 1
 *
 * Copied:
 * 7' -> 13' -> 11' -> 10' -> 1'
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N)
 *
 * Explanation:
 * - First traversal inserts copied nodes.
 * - Second traversal assigns random pointers.
 * - Third traversal separates the two lists.
 * - Each traversal visits every node exactly once.
 *
 * Space Complexity:
 * O(1)
 *
 * (Ignoring the output linked list.)
 *
 * ------------------------------------------------------------
 *
 * Alternative Approach (Brute Force):
 * - Store a mapping from original node to copied node
 *   using a HashMap.
 * - Traverse again to connect next and random pointers.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 *
 * ------------------------------------------------------------
 */

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {

        // ---------------- Optimal Approach ----------------

        // Empty list
        if (head == null)
            return null;

        // Step 1: Insert copied nodes in between original nodes
        Node temp = head;

        while (temp != null) {

            Node newNode = new Node(temp.val);

            newNode.next = temp.next;
            temp.next = newNode;

            temp = temp.next.next;
        }

        // Step 2: Connect random pointers
        temp = head;

        while (temp != null) {

            Node copyNode = temp.next;

            copyNode.random =
                (temp.random == null) ? null : temp.random.next;

            temp = temp.next.next;
        }

        // Step 3: Separate original and copied lists
        temp = head;

        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        while (temp != null) {

            // Attach copied node
            res.next = temp.next;
            res = temp.next;

            // Restore original list
            temp.next = res.next;

            temp = res.next;
        }

        return dummyNode.next;


        // ---------------- Brute Force ----------------
        /*
        if (head == null)
            return null;

        HashMap<Node, Node> hm = new HashMap<>();

        Node temp = head;

        // Create copied nodes
        while (temp != null) {

            Node newNode = new Node(temp.val);

            hm.put(temp, newNode);

            temp = temp.next;
        }

        temp = head;

        // Connect next and random pointers
        while (temp != null) {

            Node copyNode = hm.get(temp);

            copyNode.next = hm.get(temp.next);
            copyNode.random = hm.get(temp.random);

            temp = temp.next;
        }

        return hm.get(head);
        */
    }
}