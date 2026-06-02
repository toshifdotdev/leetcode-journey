// Problem: Ugly Number (#263)
// Date: 29-04-2026

// Approach:
// Repeatedly divide n by 2, 3, and 5
// Remove all occurrences of these factors
// If final number becomes 1 → it is an ugly number

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public boolean isUgly(int n) {
        if(n <= 0) return false;

        while(n % 2 == 0) n /= 2;
        while(n % 3 == 0) n /= 3;
        while(n % 5 == 0) n /= 5;

        return n == 1;
    }
}
