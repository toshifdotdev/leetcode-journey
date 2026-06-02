// Problem: Sqrt(x) (#69)
// Date: 02-06-2026

// Approach:
// Use Binary Search to find the integer square root.
// We search for the largest number whose square is <= x.

// Important:
// Instead of using mid * mid <= x,
// use mid <= x / mid to avoid integer overflow.

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int mySqrt(int x) {

        // Special case
        if(x == 0) return 0;

        int low = 1;
        int high = x;
        int ans = 0;

        while(low <= high){

            // Safer way to calculate mid
            int mid = low + (high - low) / 2;

            // mid is valid if mid*mid <= x
            // Using x/mid avoids overflow
            if(mid <= x / mid){
                ans = mid;      // store possible answer
                low = mid + 1;  // try finding bigger valid value
            } else {
                high = mid - 1; // mid too large
            }
        }

        return ans;
    }
}