// Problem: Search in Rotated Sorted Array (#33)
// Date: 09-07-2026

// Approach (Optimal - Modified Binary Search)

// Time Complexity : O(log n)
// Space Complexity: O(1)

class Solution {

    public int search(int[] nums, int target) {

        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Target found
            if (nums[mid] == target)
                return mid;

            // -------------------------------------------------
            // Check whether the LEFT half is sorted
            //
            // Example:
            // 4 5 6 7 | 0 1 2
            // ^     ^
            // low  mid
            // -------------------------------------------------
            if (nums[low] <= nums[mid]) {

                // Target lies inside the sorted left half
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                }
                // Otherwise search in right half
                else {
                    low = mid + 1;
                }
            }

            // -------------------------------------------------
            // Otherwise, RIGHT half must be sorted
            //
            // Example:
            // 6 7 0 | 1 2 4 5
            //       ^       ^
            //      mid    high
            // -------------------------------------------------
            else {

                // Target lies inside the sorted right half
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                }
                // Otherwise search in left half
                else {
                    high = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}