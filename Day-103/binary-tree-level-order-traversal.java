/**
 * Problem: Binary Tree Level Order Traversal (#102)
 * Date: 02-11-2026
 *
 * ------------------------------------------------------------
 * Approach: Breadth-First Search (BFS) using Queue
 * ------------------------------------------------------------
 *
 * 1. Create a queue and insert the root node.
 * 2. Process nodes level by level.
 * 3. Store the current queue size to determine the number
 *    of nodes present at the current level.
 * 4. Process exactly 'size' nodes:
 *    - Add the left child to the queue if it exists.
 *    - Add the right child to the queue if it exists.
 *    - Add the current node's value to the level list.
 * 5. Add the level list to the final answer.
 *
 * Base Case:
 * If the root is null, return an empty list.
 *
 * Observation:
 * The queue processes nodes in FIFO order.
 * Using the queue size ensures that nodes are grouped
 * correctly according to their levels.
 *
 * Example:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * ------------------------------------------------------------
 *
 * Time Complexity: O(N)
 * - Every node is inserted into and removed from the queue once.
 *
 * Space Complexity: O(N)
 * - Queue can hold up to O(N) nodes.
 * - Result list stores all N node values.
 *
 * ------------------------------------------------------------
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> helper = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                if(q.peek().left != null) 
                    q.offer(q.peek().left);
                if(q.peek().right != null)
                    q.offer(q.peek().right);
                helper.add(q.poll().val);
            }
            ans.add(helper);
        }

        return ans;

    }
}