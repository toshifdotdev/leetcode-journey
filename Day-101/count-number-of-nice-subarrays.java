```java
/**
 * Problem: Count Number of Nice Subarrays (#1248)
 * Date: 30-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Sliding Window + At Most Trick
 * ------------------------------------------------------------
 *
 * Observation:
 * The modulo operation converts the original array into a
 * binary representation of odd and even numbers.
 *
 * Example:
 * nums = [1, 1, 2, 1, 1]
 * k = 3
 *
 * Exactly 3 odd numbers occur in 2 subarrays:
 * [1, 1, 2, 1]
 * [1, 2, 1, 1]
 *
 * Output: 2
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
    private int countSubLessThanEqualK(int[] nums, int k) {
        int l = 0,  r = 0, sum = 0,  cnt = 0;

        while(r < nums.length) {
            sum+=nums[r]%2;

            while(sum > k) {
                sum-=nums[l]%2;
                l++;
            }
            cnt = cnt + (r-l+1);
            r++;
        }
        return cnt;

    }

    public int numberOfSubarrays(int[] nums, int k) {
        return countSubLessThanEqualK(nums, k) - countSubLessThanEqualK(nums, k - 1);
    }
}
```