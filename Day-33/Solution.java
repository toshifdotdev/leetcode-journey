// Problem: Binary Search (#704)
// Date: 08-07-2026

// Approach 1 (Iterative)

// Time Complexity : O(log n)
// Space Complexity: O(1)


// Approach 2 (Recursive)

// Time Complexity : O(log n)
// Space Complexity: O(log n)
// (Recursion stack)

class Solution {

    // -------------------------------------------------
    // Recursive Binary Search
    // -------------------------------------------------
    private int bs(int[] arr, int low, int high, int target) {

        // Base Case
        if (low > high)
            return -1;

        // Prevent integer overflow
        int mid = low + (high - low) / 2;

        if (arr[mid] == target)
            return mid;

        if (arr[mid] < target)
            return bs(arr, mid + 1, high, target);

        return bs(arr, low, mid - 1, target);
    }

    public int search(int[] nums, int target) {

        // Recursive Solution
        return bs(nums, 0, nums.length - 1, target);




        // Iterative Solution

        // int low = 0;
        // int high = nums.length - 1;

        // while (low <= high) {

        //     // Prevent integer overflow
        //     int mid = low + (high - low) / 2;

        //     if (nums[mid] == target)
        //         return mid;

        //     if (nums[mid] < target) {
        //         low = mid + 1;
        //     }
        //     else {
        //         high = mid - 1;
        //     }
        // }

        // return -1;
    }
}