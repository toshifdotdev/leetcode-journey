// Problem: Fibonacci Number (#509)
// Date: 04-06-2026

// Approach:
// Use iterative Dynamic Programming.
//
// Instead of storing all Fibonacci values,
// keep only the previous two numbers.
//
// F(n) = F(n-1) + F(n-2)
//
// Example:
// n = 5
// 0, 1, 1, 2, 3, 5
//
// prev1 = F(n-2)
// prev2 = F(n-1)
// current = prev1 + prev2

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int fib(int n) {

        if(n <= 1) return n;

        int prev1 = 0;
        int prev2 = 1;
        int current = 0;

        for(int i = 2; i <= n; i++){
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return current;
    }
}