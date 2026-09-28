/**
 * Problem: Perfect Number (#507)
 * Date: 28-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Mathematical Divisor Pairing
 *
 * Example:
 * num = 28
 *
 * Proper divisors:
 * 1, 2, 4, 7, 14
 *
 * Sum = 1 + 2 + 4 + 7 + 14 = 28
 *
 * Therefore, 28 is a perfect number.
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(sqrt(N))
 *
 * Space Complexity:
 * O(1)
 * ------------------------------------------------------------
 */

class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num <= 1) return false;

        int total = 1;

        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                total += i;

                if(num / i != i) {
                    total += (num / i);
                }
            }
        }

        return total == num;
        
    }
}