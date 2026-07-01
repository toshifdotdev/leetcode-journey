// Problem: Rotate Image (#48)
// Date: 01-07-2026

// ----------------------------------------------------
// Approach 1 (Brute Force)
// ----------------------------------------------------
//
// Create a new matrix and directly place every element
// at its rotated position.
//
// Formula:
// rotated[j][n-i-1] = matrix[i][j]
// Time Complexity : O(n²)
// Space Complexity: O(n²)


// ----------------------------------------------------
// Approach 2 (Optimal - In-place)
// ----------------------------------------------------
//
// Observation:
//
// 90° Clockwise Rotation
// = Transpose + Reverse every row
//
// Example:
//
// Original:
//
// 1 2 3
// 4 5 6
// 7 8 9
//
// Step 1 : Transpose
//
// 1 4 7
// 2 5 8
// 3 6 9
//
// Step 2 : Reverse each row
//
// 7 4 1
// 8 5 2
// 9 6 3
//
// Time Complexity : O(n²)
// Space Complexity: O(1)

class Solution {

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1 : Transpose the matrix
        
        for(int i = 0; i < n - 1; i++) {

            for(int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2 : Reverse every row
        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n / 2; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}