// Problem: Row With Maximum Ones (#2643)
// Date: 17-07-2026

// Approach (Brute Force)

// T.C. :
// O(n × m)
//
// where:
// n = number of rows
// m = number of columns
//
// Space Complexity:
// O(1)
// ------------------------------------------------------------

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {

        // Brute Force
        int indi = -1;
        int maxiOnes = -1;

        int n = mat.length;
        int m = mat[0].length;

        // Traverse every row
        for (int i = 0; i < n; i++) {

            // Count number of ones in current row
            int cntSum = 0;

            for (int j = 0; j < m; j++) {
                cntSum += mat[i][j];
            }

            // Update answer if current row has more ones
            if (cntSum > maxiOnes) {
                maxiOnes = cntSum;
                indi = i;
            }
        }

        return new int[] { indi, maxiOnes };
    }
}