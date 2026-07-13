// Problem: Magnetic Force Between Two Balls (#1552)
// Date: 13-07-2026

// Approach (Optimal - Binary Search on Answer)


// Time Complexity:
// Sorting               : O(n log n)
// Feasibility Check     : O(n)
// Binary Search         : O(log(maxDistance))
// Overall               : O(n log n + n log(maxDistance))

// Space Complexity:
// O(1) (Ignoring sorting space)

class Solution {

    // Check if all balls can be placed with at least 'dist' distance
    private boolean canWePlace(int[] arr, int dist, int balls) {

        int cntBall = 1;      // First ball is always placed
        int last = arr[0];    // Position of last placed ball

        for(int i = 1; i < arr.length; i++) {

            // Place next ball only if minimum distance is maintained
            if((arr[i] - last) >= dist) {
                cntBall++;
                last = arr[i];
            }

            // Successfully placed all balls
            if(cntBall >= balls) {
                return true;
            }
        }

        return false;
    }

    public int maxDistance(int[] position, int m) {

        // Sort basket positions
        Arrays.sort(position);

        int n = position.length;

        int low = 1;
        int high = position[n - 1] - position[0];

        while(low <= high) {

            int mid = low + (high - low) / 2;

            // If current distance is possible,
            // try finding an even larger minimum distance
            if(canWePlace(position, mid, m)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        // Largest possible minimum distance
        return high;
    }
}