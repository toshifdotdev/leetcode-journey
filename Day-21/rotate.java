// Problem: Rotate Array (#189)
// Date: 23-06-2026

// Approach 1 (Brute Force):
// 1. Store last k elements in a temporary array.
// 2. Shift remaining elements to the right.
// 3. Place saved elements at the beginning.
//
// Time Complexity: O(n)
// Space Complexity: O(k)


// Approach 2 (Optimal - Implemented):
// Reverse Technique
//
// Example:
// nums = [1,2,3,4,5,6,7], k = 3
//
// Step 1: Reverse last k elements
// [1,2,3,4,7,6,5]
//
// Step 2: Reverse first n-k elements
// [4,3,2,1,7,6,5]
//
// Step 3: Reverse complete array
// [5,6,7,1,2,3,4]
//
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    // Helper function to reverse part of the array
    private void reverse(int[] nums, int start, int end) {

        int temp;

        while(start < end) {

            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {

        int n = nums.length;

        // If k > n, reduce unnecessary rotations
        k = k % n;

        // Reverse last k elements
        reverse(nums, n - k, n - 1);

        // Reverse first n-k elements
        reverse(nums, 0, n - k - 1);

        // Reverse complete array
        reverse(nums, 0, n - 1);
    }
}