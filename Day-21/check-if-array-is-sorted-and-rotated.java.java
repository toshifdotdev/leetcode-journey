// Problem: Check if Array Is Sorted and Rotated (#1752)
// Date: 23-06-2026

// Approach:
// A sorted array has at most one "drop".
//
// Drop means:
// nums[i] > nums[i+1]
//
// Since the array may be rotated,
// we also compare the last element with the first
// using circular indexing:
//
// nums[(i+1) % n]
//
// If more than one drop exists,
// the array cannot be obtained by a single rotation.

// Example:
// [3,4,5,1,2]
//
// 3→4 ↑
// 4→5 ↑
// 5→1 ↓ (drop #1)
// 1→2 ↑
// 2→3 ↑
//
// Only one drop → valid rotation

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean check(int[] nums) {

        int drop = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {

            // Circular comparison:
            // last element compares with first element
            if(nums[i] > nums[(i + 1) % n]) {
                drop++;
            }
        }

        return drop <= 1;
    }
}