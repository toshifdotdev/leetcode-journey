// Problem: Median of Two Sorted Arrays (#4)
// Date: 15-07-2026

// Approach (Optimal - Binary Search on Partition)

// Time Complexity:
// O(log(min(n, m)))
//
// Space Complexity:
// O(1)
// ------------------------------------------------------------

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1;

        int n = n1 + n2;

        // Number of elements required in the left partition
        int left = (n1 + n2 + 1) / 2;

        while (low <= high) {

            // Partition index in nums1
            int mid1 = (low + high) / 2;

            // Partition index in nums2
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            // Right element of nums1 partition
            if (mid1 < n1) r1 = nums1[mid1];

            // Right element of nums2 partition
            if (mid2 < n2) r2 = nums2[mid2];

            // Left element of nums1 partition
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];

            // Left element of nums2 partition
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            // Correct partition found
            if (l1 <= r2 && l2 <= r1) {

                // Odd number of elements
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                }

                // Even number of elements
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2d;
            }

            // Move partition towards left
            else if (l1 > r2) {
                high = mid1 - 1;
            }

            // Move partition towards right
            else {
                low = mid1 + 1;
            }
        }

        return 0d;

        // ------------------------------------------------------------
        // Brute Force (Merge Both Arrays)
        // Time  : O(n + m)
        // Space : O(n + m)
        // ------------------------------------------------------------

        // int i = 0;
        // int j = 0;
        // int k = 0;
        // int m = nums1.length;
        // int n = nums2.length;
        // int total = m + n;

        // int[] temp = new int[total];

        // while (i < m && j < n) {
        //     if (nums1[i] <= nums2[j]) {
        //         temp[k++] = nums1[i++];
        //     } else {
        //         temp[k++] = nums2[j++];
        //     }
        // }

        // while (i < m) {
        //     temp[k++] = nums1[i++];
        // }

        // while (j < n) {
        //     temp[k++] = nums2[j++];
        // }

        // if (total % 2 == 0) {
        //     return (temp[total / 2] + temp[(total / 2) - 1]) / 2f;
        // }

        // return (float) temp[total / 2];
    }
}