// Problem: Spiral Matrix (#54)
// Date: 01-07-2026

// ----------------------------------------------------
// Approach:
// Boundary Traversal (Spiral Traversal)
//
// Maintain four boundaries:
//
// top
// bottom
// left
// right
//
// Traverse in this order:
//
// 1. Left  -> Right
// 2. Top   -> Bottom
// 3. Right -> Left
// 4. Bottom -> Top
//
// After every traversal, shrink the corresponding
// boundary.
//
// Two safety checks are required:
//
// if(top <= bottom)
//      Traverse Left
//
// if(left <= right)
//      Traverse Up
//
// These prevent revisiting elements when only
// one row or one column remains.
//
// Time Complexity : O(n * m)
// Space Complexity: O(n * m) for returnning the ans
// O(1) when (Ignoring the output list.)

class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        // Current boundaries
        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;

        while(left <= right && top <= bottom) {

            // ----------------------------------
            // Step 1 : Traverse Left -> Right
            // ----------------------------------
            for(int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // ----------------------------------
            // Step 2 : Traverse Top -> Bottom
            // ----------------------------------
            for(int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // ----------------------------------
            // Step 3 : Traverse Right -> Left
            //
            // Execute only if a bottom row
            // still exists.
            // ----------------------------------
            if(top <= bottom) {

                for(int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // ----------------------------------
            // Step 4 : Traverse Bottom -> Top
            //
            // Execute only if a left column
            // still exists.
            // ----------------------------------
            if(left <= right) {

                for(int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}