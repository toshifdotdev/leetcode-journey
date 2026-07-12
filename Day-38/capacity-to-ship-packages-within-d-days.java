// Problem: Capacity To Ship Packages Within D Days (#1011)
// Date: 12-07-2026

// Approach (Optimal - Binary Search on Answer)

// Time Complexity : O(n × log(sum(weights)))
// Space Complexity: O(1)

class Solution {

    // Returns the number of days required
    // to ship all packages using the given capacity.
    private int calculateDays(int[] w, int cap) { // cap == capacity

        int days = 1;
        int load = 0;

        for(int i = 0; i < w.length; i++) {

            // Current package cannot fit in today's shipment.
            if(load + w[i] > cap) {

                days += 1;
                load = w[i];
            }

            // Load the current package.
            else {

                load += w[i];
            }
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {

        // Search Space
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while(low <= high) {

            int mid = low + (high - low) / 2;

            int daysReq = calculateDays(weights, mid);

            // Current capacity is sufficient.
            // Try to minimize it.
            if(daysReq <= days) {

                high = mid - 1;
            }

            // Capacity is too small.
            // Increase it.
            else {

                low = mid + 1;
            }
        }

        // Minimum valid capacity.
        return low;
    }
}