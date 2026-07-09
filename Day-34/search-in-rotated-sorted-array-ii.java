// Problem: Search in Rotated Sorted Array II (#81) - Containing Duplicates
// Date: 09-07-2026

// Approach (Optimal - Modified Binary Search)

//
// Time Complexity:
// Average : O(log n)
// Worst   : O(n/2)  (when many duplicates exist)

// Space Complexity : O(1)

class Solution {

    public boolean search(int[] nums, int target) {

        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return true;

            // Duplicate found shrink array until duplicate got elimiated
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {

                // Target lies inside left half
                if (nums[low] <= target &&
                    target <= nums[mid]) {

                    high = mid - 1;
                }
                // Otherwise search right half
                else {
                    low = mid + 1;
                }
            }

            // Right half is sorted
            else {

                // Target lies inside right half
                if (nums[mid] <= target &&
                    target <= nums[high]) {

                    low = mid + 1;
                }
                // Otherwise search left half
                else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}