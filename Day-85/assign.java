/**
 * Problem: Assign Cookies (LeetCode #455)
 * Date: 23-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Greedy + Two Pointers
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(n log n + m log m)
 *
 * Sorting both arrays dominates the complexity.
 *
 * Space Complexity:
 * O(1) auxiliary space
 * (Ignoring the space used internally by Arrays.sort.)
 *
 * ------------------------------------------------------------
 */

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int n = g.length;
        int m = s.length;

        int i = 0, j = 0;

        while(i < n && j < m) {

            // Current cookie can satisfy the current child.
            if(s[j] >= g[i]) {
                i++;
                j++;
            }
            else {
                // Cookie is too small, so try the next cookie.
                j++;
            }
        }
        
        // i represents the number of satisfied children.
        return i;
    }
}