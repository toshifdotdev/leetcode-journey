// Problem: Sort Colors (#75)
// Date: 28-06-2026

// Approach 1 (Brute Force):
// Count the number of 0s, 1s and 2s,
// then overwrite the array.
//
// Time Complexity: O(n)
// Space Complexity: O(1)


// Approach 2 (Optimal - Implemented):
// Dutch National Flag Algorithm
//
// Maintain three pointers:
//
// low  -> next position for 0
// mid  -> current element being processed
// high -> next position for 2
//
// Regions:
// ------------------------------------------------
// 0 ... low-1      -> all 0s
// low ... mid-1    -> all 1s
// mid ... high     -> unknown elements
// high+1 ... n-1   -> all 2s
// ------------------------------------------------
//
// Rules:
//
// If nums[mid] == 0
//      swap(low, mid)
//      low++
//      mid++
//
// If nums[mid] == 1
//      mid++
//
// If nums[mid] == 2
//      swap(mid, high)
//      high--
//
// Note:
// When swapping with high, DO NOT increment mid.
// The new element at mid has not been processed yet.

// Example:
// nums = [2,0,2,1,1,0]
//
// Final Output:
// [0,0,1,1,2,2]

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high) {

            if(nums[mid] == 0) {

                // Place 0 in the left region
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;

                low++;
                mid++;
            }
            else if(nums[mid] == 1) {

                // 1 is already in the correct middle region
                mid++;
            }
            else {

                // Place 2 in the right region
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }
}