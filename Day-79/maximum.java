/**
 * Problem: Maximum 69 Number(#1323)
 * Date: 16-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Greedy
 *
 * Time Complexity:
 * O(log n)
 *
 * Space Complexity:
 * O(1)
 *
 * ------------------------------------------------------------
 */

class Solution {
    public int maximum69Number (int num) {

        // only change 6  jha mile 
        // sbse pehla occurence left se 6 use 9 bnana hai 
        int indi = 0;  // first occur of 6 where 
        int temp = num;

        int i = 0;  // knse index p hai wo (R->L == right wle ki 1 val hai)

        while(temp != 0) {
            i++;
            int rem = temp%10;
            temp = temp/10;
            if(rem == 6) {
                indi = i;
            }
        }

        // 9669 (indi = 2)
        // we need 9969 that will be our biggest no.
        // sp if we place 3 below that 6 then add to make it 9 we got our no.
        // so we cand 300 to that right 9669+300 = 9969
        
        // for edge case 9999 --> indi = 0 then indi -1 (-1) and 10^-1 =0.1 which convert to int we get 0


        return num + (3 * (int)Math.pow(10, indi - 1));
        
    }
}