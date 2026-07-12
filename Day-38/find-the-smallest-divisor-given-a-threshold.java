// Problem: Find the Smallest Divisor Given a Threshold (#1283)
// Date: 12-07-2026

// Approach (Optimal - Binary Search on Answer)

// Time Complexity : O(n × log(max(nums)))
// Space Complexity: O(1)

class Solution {

    private boolean possiDiv(int[] arr, int divisor, int threshold) {

        long total = 0;

        for(int i = 0; i < arr.length; i++) {

            total += (long)Math.ceil((double)arr[i] / divisor);
        }

        if(threshold >= total)
            return true;
        else
            return false;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int n = nums.length;

        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();

        while(low <= high) {

            int mid = low + (high - low) / 2;

            // Current divisor is valid.
            // Try to find an even smaller divisor.
            if(possiDiv(nums, mid, threshold)) {

                high = mid - 1;
            }

            // Current divisor is too small.
            // Increase the divisor.
            else {

                low = mid + 1;
            }
        }

        // Smallest valid divisor
        return low;
    }
}