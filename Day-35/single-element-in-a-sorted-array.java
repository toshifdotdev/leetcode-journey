// Problem: Single Element in a Sorted Array (#540)
// Date: 10-07-2026

// Approach (Optimal - Modified Binary Search)
//
// Time Complexity : O(log n)
// Space Complexity: O(1)

class Solution {

    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        // Edge Cases
        if (n == 1)
            return nums[0];

        if (nums[0] != nums[1])
            return nums[0];

        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];

        int low = 1;
        int high = n - 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Found the unique element
            if (nums[mid] != nums[mid - 1]
                    && nums[mid] != nums[mid + 1]) {

                return nums[mid];
            }

            // --------------------------------------------
            // We are on the left half
            //
            // Pairing pattern is still correct.
            //
            // Odd index  -> matches previous
            // Even index -> matches next
            //
            // Eliminate left half.
            // --------------------------------------------
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1])
                    || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {

                low = mid + 1;
            }

            // --------------------------------------------
            // Pairing pattern is broken.
            //
            // The single element lies on the left side.
            //
            // Eliminate right half.
            // --------------------------------------------
            else {

                high = mid - 1;
            }
        }

        return -1;
    }
}