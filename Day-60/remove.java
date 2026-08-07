/**
 * Problem: Remove Element (#27)
 * Date: 07-08-2026
 *
 * ------------------------------------------------------------
 * Approach (Custom Swapping Approach)
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * Worst Case: O(n²)
 *
 * Space Complexity:
 * O(1)
 *
 * ------------------------------------------------------------
 *
 * Optimal Approach:
 * - Use two pointers.
 * - Copy every element not equal to val to the front
 *   of the array.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 *
 * ------------------------------------------------------------
 */

class Solution {

        // private void swap(int[] arr, int i, int j) {

        //     int temp = arr[i];
        //     arr[i] = arr[j];
        //     arr[j] = temp;
        // }

        public int removeElement(int[] nums, int val) {

            // Optimal
            int k = 0;

            for(int i = 0; i < nums.length; i++) {

                if(nums[i] != val) {
                    nums[k] = nums[i];
                    k++;
                }
            }

            return k;

        // Brute


        //     int len = nums.length;

        //     if (len == 0 || (len == 1 && nums[0] == val))
        //         return 0;

        //     int ans = len;

        //     for (int i = 0; i < len; i++) {

        //         int j = i;
        //         while (j < len && nums[j] == val) {
        //             j++;
        //         }

        //         if (j >= len) {
        //             ans = i;
        //             break;
        //         }
        //         swap(nums, i, j);
        //     }

        //     return ans;
        }
}
