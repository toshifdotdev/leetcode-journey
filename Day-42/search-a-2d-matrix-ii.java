// Problem: c
// Date: 17-07-2026

// Approach (Optimal - Staircase Search)

//
// Time Complexity:
// O(m + n)
//
// where:
// m = number of rows
// n = number of columns
//
// Space Complexity:
// O(1)
// ------------------------------------------------------------

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;      // Total rows
        int n = matrix[0].length;   // Total columns

        // Start from the top-right corner
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            }

            // Target is larger -> move down
            else if (matrix[row][col] < target) {
                row++;
            }

            // Target is smaller -> move left
            else {
                col--;
            }
        }

        return false;
    }
}