// Problem: Find Peak Element (#162)
// Date: 10-07-2026

// Approach (Optimal - Binary Search)

//
// Found the answer.
//
// Time Complexity : O(log n)
// Space Complexity: O(1)

class Solution {

    public int findPeakElement(int[] nums) {

        int n = nums.length;

        // Edge Cases
        if (n == 1)
            return 0;

        if (nums[0] > nums[1])
            return 0;

        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        int low = 1;
        int high = n - 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Found the peak element
            if (nums[mid] > nums[mid - 1]
                    && nums[mid] > nums[mid + 1]) {

                return mid;
            }

            // ----------------------------------
            // Increasing slope
            //
            // Peak exists on the right.
            // Eliminate left half.
            // ----------------------------------
            else if (nums[mid] > nums[mid - 1]) {

                low = mid + 1;
            }

            // ----------------------------------
            // Decreasing slope
            //
            // Peak exists on the left.
            // Eliminate right half.
            // ----------------------------------
            else {

                high = mid - 1;
            }
        }

        return -1;
    }
}