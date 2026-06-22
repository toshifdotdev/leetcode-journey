// Problem: Remove Duplicates from Sorted Array (#26)
// Date: 22-06-2026

// Approach:
// Use two pointers.
//
// i -> points to the last unique element.
// j -> scans the array.
//
// Since the array is already sorted,
// duplicates are always adjacent.
//
// When nums[j] != nums[i],
// a new unique element is found.
// Place it at i+1 and move i forward.

// Example:
// [0,0,1,1,1,2,2,3,3,4]
//
// i=0
// j scans the array
//
// Result:
// [0,1,2,3,4,_,_,_,_,_]
//
// Return length = 5

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int removeDuplicates(int[] nums) {

        int i = 0;

        for(int j = 1; j < nums.length; j++) {

            // New unique element found
            if(nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }

        // Number of unique elements
        return i + 1;
    }
}