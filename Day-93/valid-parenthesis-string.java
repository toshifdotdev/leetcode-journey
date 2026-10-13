```java
/**
 * Problem: Valid Parenthesis String (#678)
 * Date: 14-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Greedy (Range Tracking)
 * ------------------------------------------------------------
 *
 * Maintain two variables:
 * - min: Minimum possible number of unmatched opening brackets.
 * - max: Maximum possible number of unmatched opening brackets.
 *
 * Traverse the string character by character.
 *
 * 1. If the character is '(':
 *    Increase both min and max because an opening bracket
 *    increases the unmatched opening bracket count.
 *
 * 2. If the character is ')':
 *    Decrease both min and max because a closing bracket
 *    matches an opening bracket.
 *
 * 3. If the character is '*':
 *    It can represent '(', ')' or an empty string.
 *    Therefore, decrease min and increase max.
 *
 * After processing each character:
 * - If min becomes negative, reset it to 0 because the minimum
 *   possible unmatched opening bracket count cannot be negative.
 * - If max becomes negative, return false because even treating
 *   every '*' as '(' cannot balance the closing brackets.
 *
 * At the end, return true if min == 0, meaning a valid
 * interpretation with no unmatched opening brackets exists.
 *
 * Observation:
 * Instead of checking every possible interpretation of '*',
 * we track the range of possible unmatched opening brackets.
 *
 * Example:
 * s = "(*))"
 *
 * '(' -> min = 1, max = 1
 * '*' -> min = 0, max = 2
 * ')' -> min = 0, max = 1
 * ')' -> min = 0, max = 0
 *
 * Output: true
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N) - one traversal of the string
 *
 * Space Complexity:
 * O(1) - only two variables are maintained
 * ------------------------------------------------------------
 */

class Solution {
    // Brute - Force 
    // private boolean check(String s, int ind, int cnt) {
    //     if(cnt < 0) return false;

    //     if(s.length() == ind) {
    //          return cnt == 0;
    //     }

    //     if(s.charAt(ind) == '(') {
    //         return check(s, ind+1, cnt+1);
    //     }
    //     else if(s.charAt(ind) == ')') { 
    //         return check(s, ind+1, cnt-1);
    //     }

    //     return (check(s, ind+1, cnt+1) || check(s, ind + 1, cnt-1) || check(s,ind+1, cnt));
    // }

    public boolean checkValidString(String s) {
        // return check(s, 0, 0);

        // Optimal - Range
        int min = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                min++; max++;
            }
            else if(s.charAt(i) == ')') {
                min = min-1;
                max = max-1;
            }
            else {
                min = min - 1;
                max = max+1;
            }

            if(min < 0) min = 0;

            // range hin ni h there fore not possibel 
            if(max < 0) return false;
        }

        return min == 0;
    }
}
```