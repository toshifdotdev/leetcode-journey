/**
 * Problem: Find Pairs with Given Sum in a Sorted Doubly Linked List (GFG)
 * Date: 03-08-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - Two Pointers)
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(n)
 * - Left and right pointers together traverse the list only once.
 *
 * Space Complexity:
 * O(1)
 * - Ignoring the output list.
 *
 * ------------------------------------------------------------
 *
 * Alternative Approach (Brute Force):
 * - Fix one node and check every node after it.
 *
 * Time Complexity : O(n²)
 * Space Complexity: O(1)
 *
 * ------------------------------------------------------------
 */

/* Structure of Doubly Linked List Node
class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
};
*/

class Solution {

    public ArrayList<ArrayList<Integer>> givenSumPairs(Node head, int target) {

        // Left pointer starts from the beginning
        Node left = head;

        // Right pointer starts from the end
        Node right = head;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // Move right pointer to the last node
        while (right.next != null) {
            right = right.next;
        }

        // Continue until pointers meet/cross
        while (left.data < right.data) {

            int sum = left.data + right.data;

            // Pair found
            if (sum == target) {

                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(left.data);
                temp.add(right.data);
                ans.add(temp);

                // Move both pointers
                left = left.next;
                right = right.prev;
            }

            // Need a smaller sum
            else if (sum > target) {
                right = right.prev;
            }

            // Need a larger sum
            else {
                left = left.next;
            }
        }

        return ans;

        // ---------------- Brute Force ----------------
        /*
        Node temp1 = head;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while (temp1 != null) {

            Node temp2 = temp1.next;

            while (temp2 != null) {

                if (temp1.data + temp2.data == target) {

                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(temp1.data);
                    temp.add(temp2.data);

                    ans.add(temp);
                }

                if (temp1.data + temp2.data > target)
                    break;

                temp2 = temp2.next;
            }

            temp1 = temp1.next;
        }

        return ans;
        */
    }
}