/**
 * Problem: Binary Tree Preorder Traversal (#144)
 * Date: 01-11-2026
 *
 * ------------------------------------------------------------
 * Approach: Recursive DFS (Preorder Traversal)
 * ------------------------------------------------------------
 *
 * Example:
 * Input: root = [1, null, 2, 3]
 * Output: [1, 2, 3]
 *
 * Observation:
 * The root is processed before its left and right subtrees.
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
    private void preOrder(List<Integer> ans, TreeNode root) {
        if(root == null) return;
        ans.add(root.val);
        preOrder(ans, root.left);
        preOrder(ans,root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(ans, root);
        return ans;


    }
}