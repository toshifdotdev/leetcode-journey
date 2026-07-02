// Problem: Pascal's Triangle (#118)
// Date: 03-07-2026

// Approach (Optimal)
//
// We generate every row independently and
// append it to the final Pascal Triangle.
//
// Time Complexity : O(numRows²)
// Space Complexity: O(1) Auxiliary
// (Output list is not counted.)

class Solution {

    // Generates a single row of Pascal's Triangle.
    private List<Integer> genrateRows(int row) {

        List<Integer> ansRow = new ArrayList<>();

        int ans = 1;
        ansRow.add(ans);
        for (int col = 1; col < row; col++) {

            ans = ans * (row - col);
            ans = ans / col;

            ansRow.add(ans);
        }

        return ansRow;
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascal = new ArrayList<>();

        // Generate each row one by one.
        for (int i = 1; i <= numRows; i++) {

            pascal.add(genrateRows(i));
        }

        return pascal;
    }
}