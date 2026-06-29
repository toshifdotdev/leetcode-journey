// Problem: Rearrange Array Elements by Sign (#2149)
// Date: 29-06-2026

// Approach:
// Create a new array of the same size.
//
// Here, since the problem guarantees an equal number of positive and
// negative elements, we know:
//
// Even indices  -> Positive numbers
// Odd indices   -> Negative numbers
//
// Maintain two counters:
//
// pos -> Next even index (0, 2, 4, ...)
// neg -> Next odd index (1, 3, 5, ...)
//
// Whenever we encounter:
//
// Positive number:
//      Place it at index = 2 * pos
//      Increment pos
//
// Negative number:
//      Place it at index = 2 * neg + 1
//      Increment neg
//
// Example:
// nums = [3,1,-2,-5,2,-4]
//
// Positive positions:
// arr[0] = 3
// arr[2] = 1
// arr[4] = 2
//
// Negative positions:
// arr[1] = -2
// arr[3] = -5
// arr[5] = -4
//
// Final:
// [3,-2,1,-5,2,-4]
//
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {

    public int[] rearrangeArray(int[] nums) {

        int pos = 0;
        int neg = 0;
        int n = nums.length;

        int arr[] = new int[n];

        for(int i = 0; i < n; i++) {

            if(nums[i] > 0) {

                // Place positive numbers at even indices
                arr[2 * pos] = nums[i];
                pos++;
            }
            else {

                // Place negative numbers at odd indices
                arr[2 * neg + 1] = nums[i];
                neg++;
            }
        }

        return arr;
    }
}