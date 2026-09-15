/**
 * Problem: Trapping Rain Water (#42)
 * Date: 15-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Prefix Maximum + Suffix Maximum
 * ------------------------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * ------------------------------------------------------------
 */

class Solution {

    // Prefix maximum array approach (not used)
    // private void prefixSum(int[] pSum, int[] height, int n) {
    //     pSum[0] = height[0];
    //
    //     for(int i = 1; i < n; i++) {
    //         pSum[i] = Math.max(height[i], pSum[i-1]);
    //     }
    // }

    private void suffixSum(int[] sSum, int[] height, int n) {

        // Build suffix maximum array
        sSum[n-1] = height[n-1];

        for(int i = n-2; i >= 0; i--) {
            sSum[i] = Math.max(height[i], sSum[i+1]);
        }
    }

    public int trap(int[] height) {

        int n = height.length;

        // Prefix array is not required because we maintain
        // leftMax while traversing.
        // int[] pSum = new int[n];

        int leftMax = -1;  // Heights are non-negative

        int[] sSum = new int[n];

        // prefixSum(pSum, height, n);
        suffixSum(sSum, height, n);

        int total = 0;

        for(int i = 0; i < n; i++) {

            // Update maximum height on the left
            leftMax = Math.max(height[i], leftMax);

            // Maximum height on the right
            int rightMax = sSum[i];

            // Water can be trapped only if the current height
            // is smaller than both boundaries.
            if(height[i] < leftMax && height[i] < rightMax) {

                total = total +
                        (Math.min(leftMax, rightMax) - height[i]);
            }
        }

        return total;
    }
}