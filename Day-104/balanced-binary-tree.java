/**
 * Problem: Balanced Binary Tree (#110)
 * Date: 04-11-2026
 *
 * ------------------------------------------------------------
 * Approach: Optimized DFS (Bottom-Up Height Calculation)
 * ------------------------------------------------------------
 *
 * 1. Calculate the height of the left subtree.
 * 2. If the left subtree is unbalanced, return -1 immediately.
 * 3. Calculate the height of the right subtree.
 * 4. If the right subtree is unbalanced, return -1 immediately.
 * 5. Check whether the height difference between the
 *    left and right subtrees is greater than 1.
 * 6. If unbalanced, return -1; otherwise, return the height.
 *
 * Base Case:
 * If the current node is null, return 0.
 *
 * Observation:
 * - A balanced binary tree has a height difference of
 *   at most 1 between the left and right subtrees
 *   of every node.
 * - Returning -1 indicates that an unbalanced subtree
 *   has been found.
 * - This avoids repeatedly calculating subtree heights.
 *
 * Example:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * ------------------------------------------------------------
 *
 * Time Complexity: O(N)
 * - Every node is visited exactly once.
 *
 * Space Complexity: O(H)
 * - H is the height of the tree due to the recursion stack.
 * - O(N) in the worst case for a skewed tree.
 *
 * ------------------------------------------------------------
 */
class Solution {
    private int dfsHeight(TreeNode root) {
        if(root == null) return 0;

        int lh = dfsHeight(root.left);
        if(lh == -1) return -1;
        int rh = dfsHeight(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh - rh) > 1) return -1;

        return 1+Math.max(lh, rh);
    }
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;

    }
}