/**
 * Problem: Same Tree (#100)
 * Date: 04-11-2026
 *
 * ------------------------------------------------------------
 * Approach: Recursive DFS
 * ------------------------------------------------------------
 *
 * 1. Check whether both nodes are null.
 * 2. If one node is null and the other is not, return false.
 * 3. Compare the values of both nodes.
 * 4. Recursively compare their left subtrees.
 * 5. Recursively compare their right subtrees.
 *
 * Observation:
 * Two binary trees are identical if:
 * - Their corresponding nodes have the same values.
 * - Their structures are exactly the same.
 *
 * Example:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * ------------------------------------------------------------
 *
 * Time Complexity: O(N)
 * - Every corresponding node is visited at most once.
 *
 * Space Complexity: O(H)
 * - H is the height of the tree due to the recursion stack.
 * - O(N) in the worst case for a skewed tree.
 *
 * ------------------------------------------------------------
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return (p == q);

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}