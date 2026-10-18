```java
/**
 * Problem: Count Integers With Even Digit Sum (#2180)
 * Date: 18-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Mathematical Observation
 * ------------------------------------------------------------
 *
 * First, calculate the sum of the digits of num.
 *
 * The number of integers from 1 to num with an even digit sum
 * can be determined directly using a mathematical formula.
 *
 * - If the digit sum of num is even, the count is num / 2.
 * - If the digit sum of num is odd, the count is (num - 1) / 2.
 *
 * Both cases can be combined into:
 *
 * (num - (sum % 2)) / 2
 *
 * Here, sum % 2 determines whether the digit sum is odd or even.
 *
 * Observation:
 * Among consecutive positive integers, the digit-sum parity
 * alternates often enough for this counting formula to work
 * for the range from 1 to num.
 *
 * Example:
 * num = 4
 *
 * Digit sums:
 * 1 -> 1 (odd)
 * 2 -> 2 (even)
 * 3 -> 3 (odd)
 * 4 -> 4 (even)
 *
 * Even digit sums: 2, 4
 *
 * Output: 2
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(log N) - calculating the digit sum
 *
 * Space Complexity:
 * O(1)
 * ------------------------------------------------------------
 */

class Solution {
    public int countEven(int num) {
        // Optimal

        int cnt = 0;
        int temp = num;
        int sum = 0;
        while(temp > 0) {
            int rem = temp%10;
            sum+=rem;
            temp/=10;
        }

        // sum event total count of numer of even upto that num is (num-0)/2
        // if sum is odd then (num-1)/2
        // or(num - (sum%2))/2

        return (num - (sum%2))/2;

        // Brute 
        // int cnt = 0;
        // for(int i = 2; i <= num; i++) {
        //     int sum = 0;
        //     int temp = i;
        //     while(temp > 0) {
        //         int rem = temp%10;
        //         sum+=rem;
        //         temp/=10;
        //     }
        //     if((sum & 1) == 0) cnt++;
        // }
        // return cnt;
    }
}
```