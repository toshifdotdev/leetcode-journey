// Problem: Maximum Product Subarray (#152)
// Date: 06-07-2026

// Approach 1 (Brute Force)

// Time Complexity : O(n²)
// Space Complexity: O(1)


// Approach 2 (Optimal - Prefix & Suffix Traversal)
//
// Observation:
//
// Negative numbers can change the sign of the product.
//
// • Even number of negatives -> Product becomes positive.
// • Odd number of negatives  -> One negative should be excluded.
//
// Therefore, the maximum product may come from:
//
// 1. Prefix traversal (Left -> Right)
// 2. Suffix traversal (Right -> Left)
//
// Also,
// whenever product becomes 0,
// reset it to 1 because any subarray after
// the zero starts a fresh product.
//
// Example:
//
// nums = [2,3,-2,4]
//
// Prefix:
//
// 2 -> 6 -> -12 -> -48
//
// Suffix:
//
// 4 -> -8 -> -24 -> -48
//
// Maximum product = 6
//
// Example:
//
// nums = [-2,-3,-4]
//
// Prefix:
//
// -2 -> 6 -> -24
//
// Suffix:
//
// -4 -> 12 -> -24
//
// Maximum product = 12
//
// Time Complexity : O(n)
// Space Complexity: O(1)

class Solution {

    public int maxProduct(int[] nums) {

        int n = nums.length;

        int maxi = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {

            if (prefix == 0) {
                prefix = 1;
            }

            if (suffix == 0) {
                suffix = 1;
            }

            prefix *= nums[i];

            suffix *= nums[n - i - 1];

            maxi = Math.max(maxi, Math.max(prefix, suffix));
        }

        return maxi;


        // Brute Force
        //
        // int maxi = Integer.MIN_VALUE;
        //
        // for (int i = 0; i < n; i++) {
        //
        //     int product = 1;
        //
        //     for (int j = i; j < n; j++) {
        //
        //         product *= nums[j];
        //
        //         maxi = Math.max(maxi, product);
        //     }
        // }
        //
        // return maxi;
    }
}