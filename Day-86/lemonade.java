/**
 * Problem: Lemonade Change (LeetCode #860)
 * Date: 24-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Greedy
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(n)
 *
 * We process each customer once.
 *
 * Space Complexity:
 * O(1)
 *
 * Only two counters are maintained.
 *
 * ------------------------------------------------------------
 */

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;

        for(int i = 0; i < bills.length; i++) {

            // Customer pays with $5.
            if(bills[i] == 5) {
                fives++;
            }

            // Customer pays with $10.
            else if(bills[i] == 10) {

                // Need one $5 as change.
                if(fives == 0) return false;

                else {
                    fives--;
                    tens++;
                }
            }

            // Customer pays with $20.
            else {

                // Prefer one $10 + one $5 as change.
                if(fives != 0 && tens != 0) {
                    tens--;
                    fives--;
                }

                // Otherwise use three $5 bills.
                else if(fives >= 3) {
                    fives = fives - 3;
                }

                // Cannot provide $15 change.
                else {
                    return false;
                }
            }
        }
        
        return true;
    }
}