/**
 * Problem: Jump Game (#Problem 55)
 * Date: 26-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Greedy
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N)
 *
 * Space Complexity:
 * O(1)
 * ------------------------------------------------------------
 */

class Solution {
    public boolean canJump(int[] nums) {
        int maxiIndi = 0;
        int n = nums.length;

        for(int i = 0;  i < n; i++) {
            if(i > maxiIndi) return false;
            else if(maxiIndi >= n - 1) return true;
            else maxiIndi = Math.max(i+nums[i], maxiIndi);
        }
        return true;
        
    }
}