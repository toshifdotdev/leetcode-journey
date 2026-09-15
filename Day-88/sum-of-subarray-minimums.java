/**
 * Problem: Sum of Subarray Minimums (#907)
 * Date: 15-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Monotonic Stack
 * ------------------------------------------------------------
 *
 * Instead of generating every subarray, we calculate how many
 * subarrays have each element as their minimum.
 *
 * For every arr[i], find:
 *
 * 1. Previous Smaller or Equal Element (PSEE)
 *    -> nearest index on the left whose value is <= arr[i]
 *
 * 2. Next Smaller Element (NSE)
 *    -> nearest index on the right whose value is < arr[i]
 *
 * If:
 *
 *     left  = i - psee[i]
 *     right = nse[i] - i
 *
 * then the number of subarrays where arr[i] is the minimum is:
 *
 *     left * right
 *
 * Therefore, arr[i] contributes:
 *
 *     arr[i] * left * right
 *
 * to the final answer.
 *
 * ------------------------------------------------------------
 *
 * Handling Duplicates:
 *
 * We use different conditions on the two sides:
 *
 * PSEE:
 *     arr[st.peek()] > arr[i]
 *
 * NSE:
 *     arr[st.peek()] >= arr[i]
 *
 * This ensures that duplicate values are not counted multiple
 * times for the same subarray.
 *
 * ------------------------------------------------------------
 *
 * Example:
 *
 * arr = [3, 1, 2, 4]
 *
 * For element 1:
 *
 * PSEE = -1
 * NSE  = 4
 *
 * left  = 1 - (-1) = 2
 * right = 4 - 1 = 3
 *
 * Number of subarrays where 1 is minimum:
 *
 * 2 * 3 = 6
 *
 * Contribution:
 *
 * 1 * 6 = 6
 *
 * We calculate the contribution of every element and add them
 * together.
 *
 * ------------------------------------------------------------
 *
 * Brute Force:
 *
 * Generate every subarray and maintain the minimum while
 * extending the subarray.
 *
 * Time Complexity: O(n²)
 *
 * This results in TLE for large inputs.
 *
 * ------------------------------------------------------------
 *
 * Optimal Complexity:
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Each element is pushed and popped from the monotonic stack
 * at most once.
 * ------------------------------------------------------------
 */

class Solution {
    private void nextSE(int[] nse, int[] arr) {
        Stack<Integer> st = new Stack<>();

        // Find Next Smaller Element
        for(int i = arr.length - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
    }

    private void prevSE(int[] psee, int[] arr) {
        Stack<Integer> st = new Stack<>();

        // Find Previous Smaller or Equal Element
        for(int i = 0; i < arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    public int sumSubarrayMins(int[] arr) {

        // Optimal
        int MOD = (int)(1e9 + 7);

        int n = arr.length;
        int[] psee = new int[n];
        int[] nse = new int[n];

        prevSE(psee, arr);
        nextSE(nse, arr);

        int total = 0;

        for(int i = 0; i < n; i++) {

            // Number of choices on the left and right
            int left = i - psee[i];
            int right = nse[i] - i;

            // Contribution of arr[i]
            total = (int)((total +
                    (arr[i] * 1L * left * right) % MOD) % MOD);
        }

        return total;


        // ----------------------------------------------------
        // Brute - Force TLE
        // ----------------------------------------------------

        // int sum = 0;
        // int MOD = (int)(1e9 + 7);
        // int n = arr.length;
        //
        // for(int i = 0; i < n; i++) {
        //     int mini = Integer.MAX_VALUE;
        //
        //     for(int j = i; j < n; j++) {
        //         mini = Math.min(arr[j], mini);
        //         sum = (sum + mini) % MOD;
        //     }
        // }
        //
        // return sum;
    }
}