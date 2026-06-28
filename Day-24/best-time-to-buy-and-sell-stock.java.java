// Problem: Best Time to Buy and Sell Stock (#121)
// Date: 29-06-2026

// Approach 1 (Brute Force):
// Try every possible buy day and every possible sell day.
//
// Time Complexity: O(n²)
// Space Complexity: O(1)


// Approach 2 (Optimal - Implemented):
// One Pass Traversal
// Example:
// prices = [7,1,5,3,6,4]
//
// Day 1:
// Minimum Price = 7
//
// Day 2:
// Minimum Price = 1
//
// Day 3:
// Profit = 5 - 1 = 4
//
// Day 5:
// Profit = 6 - 1 = 5  ← Maximum Profit
//
// Answer = 5

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public int maxProfit(int[] prices) {

        int profit = 0;
        int mini = prices[0];  // Minimum Price

        for(int i = 1;i<prices.length;i++) {
            int cost = prices[i] - mini;  // SP - min(CP)
            profit = Math.max(profit,cost); // We have to maximize the profit
            mini = Math.min(mini,prices[i]);
        }
        return profit;
    }
}