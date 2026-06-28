// Problem: Maximum Subarray (#53)
// Date: 28-06-2026

// Approach 1 (Brute Force):
// Generate all possible subarrays and calculate their sums.
//
// Time Complexity: O(n²) (or O(n³) without prefix sums)
// Space Complexity: O(1)


// Approach 2 (Optimal - Implemented):
// Kadane's Algorithm
//
// Idea:
// Keep extending the current subarray as long as its sum is positive.
// If the running sum becomes negative, discard it because it can only
// decrease the sum of any future subarray.
//
// Steps:
// 1. Add current element to running sum.
// 2. Update maximum sum found so far.
// 3. If running sum becomes negative, reset it to 0.
//
// Example:
// nums = [-2,1,-3,4,-1,2,1,-5,4]
//
// Running sums:
// -2 -> reset to 0
// 1
// -2 -> reset
// 4
// 3
// 5
// 6  ← Maximum
//
// Answer = 6
// Subarray = [4,-1,2,1]

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ; i<n ;i++) {
            sum+=nums[i];
            if(sum > maxi) {
                maxi = sum;
            }
            
            if(sum < 0) {
                sum = 0;
            }
        }
        return maxi;
        
    }
}