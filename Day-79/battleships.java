/**
 * Problem: Battleships in a Board (LeetCode #419)
 * Date: 16-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Grid Traversal
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(m * n)
 *
 * Space Complexity:
 * O(1)
 *
 * ------------------------------------------------------------
 */

class Solution {
    public int countBattleships(char[][] board) {
        int cnt = 0;

        for(int i =0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'X') {

                    // If there is an 'X' above, this cell belongs
                    // to the same vertical battleship.
                    if(i > 0 && board[i-1][j] == 'X') {
                        continue;
                    }

                    // If there is an 'X' to the left, this cell belongs
                    // to the same horizontal battleship.
                    else if(j>0 && board[i][j-1] == 'X') {
                        continue;
                    }

                    // No 'X' above or to the left, so this is the
                    // starting cell of a new battleship.
                    else {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}