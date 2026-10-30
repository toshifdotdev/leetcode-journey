/**
 * Problem: Subarrays with K Different Integers (#992)
 * Date: 30-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Sliding Window + HashMap + At Most Trick
 * ------------------------------------------------------------
 * Time Complexity:
 * O(N) expected - each element enters and leaves the window
 *                 at most once per helper function.
 *
 * Space Complexity:
 * O(N) - HashMap can store up to N distinct elements.
 * ------------------------------------------------------------
 */

class Solution {
    private int subWithDistinctLessThanEqualK(int[] nums, int k) {
        int cnt = 0, l = 0, r = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while(r < nums.length) {
            hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);
            while(hm.size()  > k) {
                hm.put(nums[l], hm.get(nums[l]) - 1);
                if(hm.get(nums[l]) == 0) hm.remove(nums[l]);
                l++;
            }
            cnt += (r-l+1);
            r++;
        }
        return cnt;

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subWithDistinctLessThanEqualK(nums, k) - subWithDistinctLessThanEqualK(nums, k - 1);

        // Brute - Force 
        // int cnt = 0, n = nums.length;

        // for(int i = 0; i < n; i++) {
        //     Set<Integer> set = new HashSet<>();
        //     for(int j = i ; j < n; j++) {
        //         set.add(nums[j]);
        //         if(set.size() > k) {
        //             break;
        //         }
        //         else if(set.size() == k) cnt++;
        //     }
        // }

        // return cnt;
    }
}
```