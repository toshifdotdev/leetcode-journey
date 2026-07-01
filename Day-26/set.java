// Problem: Set Matrix Zeroes (#73)
// Date: 01-07-2026

// Approach 1 (Brute Force):
// Whenever a zero is found, first replace 
// immediately its entire row and column to -1.
// Then again a loop wil go making -1 to 0...
//
// Time Complexity: O((n*m)*(n+m) + (n*m)) 
// Somewhere about n^3 
// Space Complexity: O(1)


// Approach 2 (Better):
// Maintain two extra arrays:
//
// row[] -> rows to be zeroed
// col[] -> columns to be zeroed
//
// First traversal:
// Store which rows and columns contain a zero.
//
// Second traversal:
// Zero every cell whose row or column is marked.
//
// Time Complexity: O(n*m)
// Space Complexity: O(n+m)


// Approach 3 (Optimal - Implemented):
// Instead of using two extra arrays,
// use:
//
// First row  -> stores column markers
// First column -> stores row markers


// Time Complexity: O(2n*m)
// Space Complexity: O(1)

class Solution {

    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = 1;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < m; j++) {

                if(matrix[i][j] == 0) {

                    matrix[i][0] = 0;

                    if(j != 0) {
                        matrix[0][j] = 0;
                    }
                    else {
                        col0 = 0;
                    }
                }
            }
        }

     
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] != 0) {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int j = 1; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

 
        if(col0 == 0) {
            for(int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}