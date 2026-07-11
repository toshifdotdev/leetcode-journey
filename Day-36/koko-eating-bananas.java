// Problem: Koko Eating Bananas (#875)
// Date: 11-07-2026

// Approach (Optimal - Binary Search on Answer)

// Time Complexity : O(n × log(maxPile))
// Space Complexity: O(1)

class Solution {

    // Returns total hours required to finish all piles
    // at the given eating speed.
    private long calcTotalTime(int[] arr, int hourly) {

        long totalTime = 0;

        for (int elem : arr) {

            totalTime += (long) Math.ceil((double) elem / hourly);
        }

        return totalTime;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long totalHrs = calcTotalTime(piles, mid);

            // Current speed is sufficient.
            // Try to minimize it.
            if (totalHrs <= h) {

                high = mid - 1;
            }

            // Current speed is too slow.
            // Increase the speed.
            else {

                low = mid + 1;
            }
        }

        // Smallest valid eating speed.
        return low;
    }
}