// Problem: Find Minimum in Rotated Sorted Array (#153)
// Date: 10-07-2026

// Approach (Optimal - Modified Binary Search)
//
// Time Complexity : O(log n)
// Space Complexity: O(1)

class Solution {

    public int findMin(int[] nums) {

        int n = nums.length;

        int low = 0;
        int high = n - 1;

        int mini = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {

                mini = Math.min(mini, nums[low]);

                // Eliminate left half
                low = mid + 1;
            }

            // Right half is sorted
            else {

                mini = Math.min(mini, nums[mid]);

                // Eliminate right half
                high = mid - 1;
            }
        }
        return mini;
    }
}