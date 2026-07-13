// Problem: Kth Missing Positive Number (#1539)
// Date: 13-07-2026

// Approach (Optimal - Binary Search)

// Time Complexity:
// O(log n)
//
// Space Complexity:
// O(1)

class Solution {

    public int findKthPositive(int[] arr, int k) {

        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Missing numbers before arr[mid]
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // low = high + 1 after Binary Search
        // Answer = high + 1 + k (or simply low + k)
        return high + 1 + k;
    }
}