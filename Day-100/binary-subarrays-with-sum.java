```java
/**
 * Problem: Binary Subarrays With Sum (#930)
 * Date: 29-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Sliding Window + At Most Trick
 * ------------------------------------------------------------
 *
 * The goal is to count subarrays whose sum is exactly equal
 * to the given goal.
 *
 * Instead of counting subarrays with sum exactly equal to goal
 * directly, use the following formula:
 *
 * Exactly(goal) = AtMost(goal) - AtMost(goal - 1)
 *
 * The helper function findSubLessThanEqual() counts the number
 * of subarrays whose sum is less than or equal to the goal.
 *
 * Since nums contains only 0s and 1s, use a sliding window:
 *
 * 1. Expand the window by adding nums[r] to sum.
 * 2. If sum exceeds goal, shrink the window from the left
 *    until sum becomes less than or equal to goal.
 * 3. Add (r - l + 1) to cnt because every subarray ending at r
 *    and starting between l and r satisfies the condition.
 *
 * If goal < 0, return 0 because non-negative array elements
 * cannot produce a negative sum.
 *
 * Observation:
 * Subtracting the count of subarrays with sum <= goal - 1
 * from those with sum <= goal leaves only subarrays whose
 * sum is exactly goal.
 *
 * Example:
 * nums = [1, 0, 1, 0, 1]
 * goal = 2
 *
 * AtMost(2) = 14
 * AtMost(1) = 10
 *
 * Exactly(2) = 14 - 10 = 4
 *
 * Output: 4
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N) - each pointer moves forward at most N times per helper.
 *
 * Space Complexity:
 * O(1) - only a few variables are used.
 * ------------------------------------------------------------
 */

class Solution {
    private int findSubLessThanEqual(int[] nums, int goal) {
        if(goal < 0) return 0;
        int l = 0, r = 0, n = nums.length;
        int cnt = 0;
        int sum = 0;
        while(r < n) {
            sum+=nums[r];
            while(sum > goal) {
                sum-=nums[l];
                l++;
            }
            cnt = cnt + (r-l+1);
            r++;
        }
        return cnt;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return findSubLessThanEqual(nums, goal) - findSubLessThanEqual(nums, goal-1);
    }
}
```