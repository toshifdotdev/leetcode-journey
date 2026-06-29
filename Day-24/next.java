// Problem: Next Permutation (#31)
// Date: 29-06-2026

// Approach:
// The next permutation is the next lexicographically greater arrangement.
//
// Steps:
//
// 1. Traverse from right and find the first index where:
//        nums[i] < nums[i + 1]
//    This is called the breakpoint.
//
// 2. If no breakpoint exists,
//    the array is in descending order (last permutation).
//    Reverse the whole array to obtain the first permutation.
//
// 3. Otherwise, traverse again from the right and find the
//    first element greater than nums[breakpoint].
//    Swap them.
//
// 4. Reverse everything after the breakpoint.
//    The suffix was originally in descending order.
//    Reversing it gives the smallest possible suffix,
//    producing the immediate next permutation.
//
// Example:
// nums = [1,2,3]
//
// Breakpoint = 2
// Swap 2 and 3
// Reverse suffix
//
// Result:
// [1,3,2]
//
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public void nextPermutation(int[] nums) {

        int ind = -1;
        int n = nums.length;

        // Step 1: Find the breakpoint
        for(int i = n - 2; i >= 0; i--) {

            if(nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        // No breakpoint means the array is already the
        // last permutation (descending order).
        // Reverse the whole array to get the first permutation.
        if(ind == -1) {

            for(int i = 0; i < n / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[n - i - 1];
                nums[n - i - 1] = temp;
            }

            return;
        }

        // Step 2: Find the first element greater than
        // nums[ind] from the right side.
        for(int i = n - 1; i > ind; i--) {

            if(nums[i] > nums[ind]) {

                // Swap
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;

                break;
            }
        }

        // Step 3: Reverse the suffix
        // to obtain the smallest possible sequence.
        int left = ind + 1;
        int right = n - 1;

        while(left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}