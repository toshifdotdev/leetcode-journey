/**
 * Problem: Next Greater Element II (#503)
 * Date: 13-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Monotonic Stack + Circular Array
 * ------------------------------------------------------------
 * Time Complexity: O(4n)
 * Space Complexity: O(2n +n)
 * ------------------------------------------------------------
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        // Optimal: Monotonic Stack
        int n = nums.length;

        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        // Traverse the circular array twice
        for(int i = 2*n-1; i >= 0; i--) {

            // Convert virtual index into actual array index
            int ind = i % n;

            // Remove elements that cannot be the next greater
            // element for the current value
            while(!st.isEmpty() && nums[ind] >= st.peek()) {
                st.pop();
            }

            // Store answer only during the first traversal
            if(i < n) {
                if(st.isEmpty()) {
                    nge[i] = -1;
                }
                else {
                    nge[i] = st.peek();
                }
            }

            // Current element becomes a candidate for elements
            // to its left
            st.push(nums[ind]);
        }

        return nge;


        // ----------------------------------------------------
        // Brute Force
        // ----------------------------------------------------

        // int n = nums.length;
        // int[] ans = new int[n];
        // Arrays.fill(ans, Integer.MIN_VALUE);
        //
        // for(int i = 0; i < n; i++) {
        //     int j = (i + 1) % n;
        //
        //     while(j != i) {
        //         if(nums[i] < nums[j]) {
        //             ans[i] = nums[j];
        //             break;
        //         }
        //
        //         j = (j + 1) % n;
        //     }
        //
        //     // No element found greater than it
        //     if(ans[i] == Integer.MIN_VALUE) {
        //         ans[i] = -1;
        //     }
        // }
        //
        // return ans;
    }
}