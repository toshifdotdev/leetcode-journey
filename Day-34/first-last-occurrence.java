// Problem: Find First and Last Position of Element in Sorted Array (#34)
// Date: 09-07-2026

// Approach 1 (Lower Bound + Upper Bound)
//
// Time Complexity : O(log n)
// Space Complexity: O(1)


// Approach 2 (Raw Binary Search)

// Time Complexity : O(log n)
// Space Complexity: O(1)

class Solution {

    // First Occurrence using Binary Search
    private int firstOccurrence(int[] arr, int target, int n) {

        int low = 0;
        int high = n - 1;
        int first = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {

                first = mid;
                // Continue searching on left side
                // to find an earlier occurrence
                high = mid - 1;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return first;
    }

    // Last Occurrence using Binary Search
    private int lastOccurrence(int[] arr, int target, int n) {

        int low = 0;
        int high = n - 1;
        int last = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {

                last = mid;

                // Continue searching on right side
                // to find a later occurrence
                low = mid + 1;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return last;
    }

    // -------------------------------------------------
    // Lower Bound
    //
    private int lowerBound(int[] arr, int target, int n) {

        int low = 0;
        int high = n - 1;
        int lb = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                lb = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return lb;
    }

    // Upper Bound
    private int upperBound(int[] arr, int target, int n) {

        int low = 0;
        int high = n - 1;
        int ub = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                ub = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ub;
    }

    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;

        // Approach 1 : Lower Bound + Upper Bound
        // -------------------------------------------------

        // int first = lowerBound(nums, target, n);
        // int last = upperBound(nums, target, n);

        // if (n == 0 || first == n || nums[first] != target) {
        //     return new int[] {-1, -1};
        // }

        // return new int[] {first, last - 1};


        // Approach 2 : Raw Binary Search
        // -------------------------------------------------

        int first = firstOccurrence(nums, target, n);

        if (first == -1)
            return new int[] {-1, -1};

        int last = lastOccurrence(nums, target, n);

        return new int[] {first, last};
    }
}