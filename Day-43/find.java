// Problem: Find a Peak Element II (#1901)
// Date: 15-07-2026

// Approach (Optimal - Binary Search on Rows)

//
// Time Complexity:
//
// Binary Search on Rows:
// O(m × log n)
//
// where
// n = number of rows
// m = number of columns
//
// (Finding maximum in every selected row takes O(m))
//
// ------------------------------------------------------------
//
// Binary Search on Columns (Commented Solution):
// O(n × log m)
//
// ------------------------------------------------------------
//
// Space Complexity:
// O(1)
// ------------------------------------------------------------

class Solution {

    // Returns the column index of the maximum element
    // in the given row.
    private int maxiElemCol(int[][] arr, int row, int colLen) {
        int maxiElem = Integer.MIN_VALUE;
        int indi = -1;

        for (int i = 0; i < colLen; i++) {
            if (arr[row][i] > maxiElem) {
                maxiElem = arr[row][i];
                indi = i;
            }
        }

        return indi;
    }

    // Returns the row index of the maximum element
    // in the given column.
    private int maxElemIndi(int[][] arr, int col, int rowLen) {
        int maxiElem = Integer.MIN_VALUE;
        int indi = -1;

        for (int i = 0; i < rowLen; i++) {
            if (arr[i][col] > maxiElem) {
                maxiElem = arr[i][col];
                indi = i;
            }
        }

        return indi;
    }

    public int[] findPeakGrid(int[][] mat) {

        // --------------------------------------------------------
        // Optimal 1: Binary Search on Rows
        // --------------------------------------------------------

        int n = mat.length;       // Number of rows
        int m = mat[0].length;    // Number of columns

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            // Find maximum element in current row
            int col = maxiElemCol(mat, mid, m);

            int top = (mid - 1 >= 0) ? mat[mid - 1][col] : -1;
            int bottom = (mid + 1 < n) ? mat[mid + 1][col] : -1;

            // Peak found
            if (mat[mid][col] > top && mat[mid][col] > bottom) {
                return new int[] { mid, col };
            }

            // Move towards the greater neighbouring row
            if (mat[mid][col] < top) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[] { -1, -1 };



        // --------------------------------------------------------
        // Optimal 2: Binary Search on Columns
        // Time: O(n log m)
        // --------------------------------------------------------

        // int m = mat.length;      // Rows
        // int n = mat[0].length;   // Columns

        // int low = 0;
        // int high = n - 1;

        // while (low <= high) {

        //     int mid = (low + high) / 2;

        //     // Find maximum element in current column
        //     int row = maxElemIndi(mat, mid, m);

        //     // Since this is the maximum in the column,
        //     // only compare left and right neighbours.
        //     int left = (mid - 1 >= 0) ? mat[row][mid - 1] : -1;
        //     int right = (mid + 1 < n) ? mat[row][mid + 1] : -1;

        //     if (mat[row][mid] > left && mat[row][mid] > right) {
        //         return new int[] { row, mid };
        //     }

        //     else if (mat[row][mid] < left) {
        //         high = mid - 1;
        //     }

        //     else {
        //         low = mid + 1;
        //     }
        // }

        // return new int[] { -1, -1 };
    }
}