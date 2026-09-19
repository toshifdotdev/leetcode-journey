/**
 * Problem: Largest Rectangle in Histogram (LeetCode #84)
 * Date: 19-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Monotonic Stack - Optimal
 *
 * Hence:
 *
 *     Width = NSE - PSE - 1
 *
 * ------------------------------------------------------------
 *
 * Example:
 *
 * heights = [2, 1, 5, 6, 2, 3]
 *
 * For height 5:
 *
 * PSE = 1
 * NSE = 4
 * Width = 4 - 1 - 1 = 2
 *
 * Area = 5 * 2 = 10
 *
 * Maximum area = 10
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(n)
 *
 * Every index is pushed into and popped from the stack
 * at most once.
 *
 * Space Complexity:
 * O(n)
 *
 * The stack can contain up to n indices.
 *
 * ------------------------------------------------------------
 */

class Solution {
    // --------------------------------------------------------
    // Better Approach: Find PSE and NSE separately
    // --------------------------------------------------------

    // private void findPse(int[] pse, int[] arr) {
    //     Stack<Integer> st = new Stack<>();
    //     int n = arr.length;

    //     for(int i = 0; i < n; i++) {
    //         while(!st.isEmpty() && arr[i] <= arr[st.peek()]) {
    //             st.pop();
    //         }

    //         pse[i] = st.isEmpty() ? -1 : st.peek();
    //         st.push(i);
    //     }
    // }

    // private void findNse(int[] nse, int[] arr) {
    //     Stack<Integer> st = new Stack<>();
    //     int n = arr.length;

    //     for(int i = n - 1; i >= 0; i--) {
    //         while(!st.isEmpty() && arr[i] <= arr[st.peek()]) {
    //             st.pop();
    //         }

    //         nse[i] = st.isEmpty() ? n : st.peek();
    //         st.push(i);
    //     }
    // }

    public int largestRectangleArea(int[] heights) {

        // Optimal
        Stack<Integer> st = new Stack<>();
        int maxiArea = 0;

        int n = heights.length;

        for(int i = 0; i < n; i++) {

            // Current bar is smaller than or equal to the bar
            // at the top, so calculate the rectangle for the
            // popped bar.
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {

                int elem = heights[st.pop()];

                // Current index is the Next Smaller Element.
                int nse = i;

                // Remaining stack top is the Previous Smaller Element.
                int pse = st.isEmpty() ? -1 : st.peek();

                // Width = nse - pse - 1
                maxiArea = Math.max(maxiArea, elem * (nse - pse - 1));       
            }

            // Maintain increasing order of heights in the stack.
            st.push(i);
        }

        // Remaining elements have no smaller element on the right.
        if(!st.isEmpty()) {
            while(!st.isEmpty()) {

                int elem = heights[st.pop()];

                int pse = st.isEmpty() ? -1 : st.peek();

                // No smaller element on the right.
                int nse = n;

                maxiArea = Math.max(maxiArea, elem * (nse - pse - 1));
            }
        }

        return maxiArea;

        // ----------------------------------------------------
        // Better Approach
        // ----------------------------------------------------

        // int n = heights.length;
        // int maxi = 0;
        // int nse[] = new int[n];
        // int pse[] = new int[n];

        // findPse(pse, heights);
        // findNse(nse, heights);

        // for(int i = 0; i < n; i++) {
        //     int left = i - pse[i];
        //     int right = nse[i] - i;

        //     maxi = Math.max(maxi,
        //         (int)(heights[i] * (nse[i] - pse[i] - 1)));
        // }

        // return maxi;
    }
}