// Problem: Merge Sorted Array (#88)
// Date: 05-07-2026

// Approach 1 (Brute Force)

// Time Complexity : O(m + n)
// Space Complexity: O(m + n)


// Approach 2 (Optimal - Three Pointers from Back)

// Time Complexity : O(m + n)
// Space Complexity: O(1)

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;          // Last valid element in nums1
        int j = n - 1;          // Last element in nums2
        int k = m + n - 1;      // Last position in nums1

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        // Copy remaining elements of nums2
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        // Brute Force (Using Extra Array)
        // int[] temp = new int[m + n];
        //
        // int i = 0;
        // int j = 0;
        // int k = 0;
        //
        // while (i < m && j < n) {
        //
        //     if (nums1[i] <= nums2[j]) {
        //         temp[k++] = nums1[i++];
        //     } else {
        //         temp[k++] = nums2[j++];
        //     }
        // }
        //
        // while (i < m) {
        //     temp[k++] = nums1[i++];
        // }
        //
        // while (j < n) {
        //     temp[k++] = nums2[j++];
        // }
        //
        // for (i = 0; i < m + n; i++) {
        //     nums1[i] = temp[i];
        // }
    }
}