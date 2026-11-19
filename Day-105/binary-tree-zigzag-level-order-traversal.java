/**
 * Problem: Binary Tree Zigzag Level Order Traversal (#103)
 * Date: 19-11-2026
 *
 * ------------------------------------------------------------
 * Approach: BFS using Queue + LinkedList
 * ------------------------------------------------------------
 *
 * 1. Use a queue to process the tree level by level.
 * 2. Maintain a boolean flag to track the traversal direction.
 * 3. If flag is true, insert the node value at the end of the level.
 * 4. If flag is false, insert the node value at the beginning.
 * 5. Add the children to the queue from left to right.
 * 6. Toggle the flag after processing each level.
 *
 * Traversal Pattern:
 * Level 1: Left -> Right
 * Level 2: Right -> Left
 * Level 3: Left -> Right
 * Level 4: Right -> Left
 *
 * Observation:
 * - Queue maintains normal BFS order.
 * - LinkedList allows insertion at both ends.
 * - flag controls the zigzag direction without changing
 *   the order in which nodes are added to the queue.
 *
 * Example:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 *
 * ------------------------------------------------------------
 *
 * Time Complexity: O(N)
 * - Every node is processed exactly once.
 *
 * Space Complexity: O(N)
 * - Queue and result list can store up to O(N) elements.
 *
 * ------------------------------------------------------------
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true; // true means L -> R
                            // false means R -> L
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();

            LinkedList<Integer> level = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if(flag) level.addLast(node.val);
                else level.addFirst(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

            }
            flag = !flag;

            ans.add(level);
        }

        return ans;
    }
}