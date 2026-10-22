```java
/**
 * Problem: Max Consecutive Ones III (#1004)
 * Date: 22-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Sliding Window + Two Pointers
 * ------------------------------------------------------------
 *
 * Maintain a sliding window using two pointers:
 * - l: Left boundary of the current window.
 * - r: Right boundary of the current window.
 *
 * The variable zeros tracks the number of zeros in the window.
 *
 * Traverse the array:
 * 1. If nums[r] == 0, increment zeros.
 * 2. If zeros > k, shrink the window from the left by one
 *    position. If the removed element is zero, decrement zeros.
 * 3. If zeros <= k, update maxLen with the current window length.
 * 4. Move r forward.
 *
 * We can flip at most k zeros, so every valid window contains
 * no more than k zeros.
 *
 * Observation:
 * This optimal approach uses an if statement instead of a while
 * loop to shrink the window at most once per iteration.
 * Although the window may temporarily contain more than k zeros,
 * its boundaries still allow us to find the maximum length.
 *
 * Example:
 * nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 * k = 2
 *
 * The longest valid window has length 6.
 *
 * Output: 6
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N) - each pointer moves forward at most N times.
 *
 * Space Complexity:
 * O(1) - only a few variables are used.
 * ------------------------------------------------------------
 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        //  Optimal
        int l = 0, r = 0, zeros = 0, maxLen = 0;
        int n = nums.length;

        while(r < n) {
            if(nums[r] == 0) zeros++;
            if(zeros > k) { 
                if(nums[l] == 0) zeros--;
                l++;

            }
            if(zeros <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;

        
        // better
        // int l = 0, r = 0, zeros = 0, maxLen = 0;
        // int n = nums.length;

        // while(r < n) {
        //     if(nums[r] == 0) zeros++;
        //     while(zeros > k) { 
        //         if(nums[l] == 0) zeros--;
        //         l++;

        //     }
        //     if(zeros <= k) {
        //         maxLen = Math.max(maxLen, r - l + 1);
        //     }
        //     r++;
        // }
        // return maxLen;


        // brute - force 
        // int maxiLen = 0;
        // int n = nums.length;
        // for(int i = 0; i < n; i++) {
        //     int cnt = 0;
        //     for(int j = i; j < n; j++) {
        //         if(nums[j] == 0) cnt++;
        //         if(cnt <= k)  maxiLen = Math.max(maxiLen, j - i+1);
        //        else { 
        //             break;  
        //         }
        //     }
        // }
        // return maxiLen;
    }
}
