// Problem: Largest Odd Number in String (#1903)
// Date: 22-07-2026

// Approach (Optimal - Greedy + Reverse Traversal)

//
// Example:
//
// Input : "35427"
//
// Scan from right:
// 7 -> Odd ✓
//
// Answer:
// "35427"
//
// Example:
//
// Input : "4206"
//
// Scan from right:
// 6 -> Even
// 0 -> Even
// 2 -> Even
// 4 -> Even
//
// No odd digit found.
//
// Answer:
// ""
// 

// Time Complexity:
// O(n)
//
// Space Complexity:
// O(1)

class Solution {

    public String largestOddNumber(String num) {

        int n = num.length();
        int indi = -1;

        // Traverse from right to left to find
        // the last odd digit.
        for (int i = n - 1; i >= 0; i--) {

            int temp = num.charAt(i) - '0';

            if (temp % 2 != 0) {
                indi = i;
                break;
            }
        }

        // No odd digit present
        if (indi == -1) {
            return "";
        }

        // Skip leading zeroes up to the odd digit
        int i = 0;
        while (i <= indi && num.charAt(i) == '0') {
            i++;
        }

        // Return the largest odd-valued substring
        return num.substring(i, indi + 1);
    }
}