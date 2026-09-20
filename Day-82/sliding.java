/**
 * Problem: Sliding Window Maximum (LeetCode #239)
 * Date: 20-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Monotonic Deque - Optimal
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(n)
 *
 * Every index is added to and removed from the Deque at most
 * once.
 *
 * Space Complexity:
 * O(k)
 *
 * The Deque stores at most k indices.
 *
 * ------------------------------------------------------------
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Optimal
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n-k+1];


        for(int i = 0; i < n; i++) {

            // Remove elements that are outside the current window.
            if(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back because
            // they cannot be the maximum while nums[i] is present.
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            // Add the current index.
            dq.offerLast(i);

            // First complete window is formed.
            if(i >= k - 1) {
                ans[i-k+1] = nums[dq.peekFirst()];
            }
        }

        return ans;


        // ----------------------------------------------------
        // TLE
        // Brute - Force
        // ----------------------------------------------------

        // int N= nums.length - k;
        // int[] arr = new int[N+1];

        // for(int i = 0; i <= N; i++) {
        //     int maxi = nums[i];
        //     for(int j = i; j <= i+k-1; j++) {
        //         maxi = Math.max(nums[j], maxi);
        //     }
        //     arr[i] = maxi;
        // }

        // return arr;
    }
}