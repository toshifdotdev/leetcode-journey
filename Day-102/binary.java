/**
 * Problem: Binary Tree Postorder Traversal (#145)
 * Date: 01-11-2026
 *
 * ------------------------------------------------------------
 * Approach 1: Iterative DFS using 2 Stacks
 * ------------------------------------------------------------
 *
 * 1. Push the root node into the first stack (st1).
 * 2. Pop a node from st1 and push it into st2.
 * 3. Push its left and right children into st1 if they exist.
 * 4. After processing all nodes, pop elements from st2
 *    and add their values to the result list.
 *
 * Postorder Traversal:
 * Left -> Right -> Root
 *
 * Observation:
 * The first stack processes nodes in a way that produces
 * Root -> Right -> Left when the second stack is reversed.
 *
 * ------------------------------------------------------------
 * Approach 2: Recursive DFS
 * ------------------------------------------------------------
 *
 * 1. Recursively traverse the left subtree.
 * 2. Recursively traverse the right subtree.
 * 3. Add the current node's value to the result list.
 *
 * ------------------------------------------------------------
 *
 * Time Complexity: O(N)
 * - Every node is processed once.
 *
 * Space Complexity: O(N)
 * - Two stacks may store up to N nodes.
 * - The result list also stores N values.
 *
 * ------------------------------------------------------------
 */
class Solution {
    private void traverse(List<Integer> ans, TreeNode root) {
        if(root == null) return;
        traverse(ans, root.left);
        traverse(ans, root.right);
        ans.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        // Iterative using 2 stacks 
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> postOrder= new ArrayList<>();
        if(root == null) return postOrder;

        st1.push(root);

        while(!st1.isEmpty()) {
            root = st1.pop();
            st2.push(root);

            if(root.left != null) {
                st1.push(root.left);
            }

            if(root.right != null) {
                st1.push(root.right);
            }

        }

        while(!st2.isEmpty()) {
            postOrder.add(st2.pop().val);
        }
        return postOrder;

        // Recursion 
        // List<Integer> ans = new ArrayList<>();
        // if(root == null) return ans;
        // traverse(ans, root);
        // return ans;
    }
}