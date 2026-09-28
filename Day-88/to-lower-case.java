/**
 * Problem: To Lower Case (#709)
 * Date: 28-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Character Manipulation
 * ------------------------------------------------------------
 *
 * Traverse each character of the string.
 *
 * If the character is an uppercase English letter ('A' to 'Z'),
 * add 32 to its ASCII value to convert it into lowercase.
 *
 * Otherwise, append the character as it is.
 *
 * Observation:
 * In ASCII:
 * 'A' = 65 and 'a' = 97
 * 'B' = 66 and 'b' = 98
 * ...
 *
 * Therefore, the difference between uppercase and lowercase
 * letters is 32.
 *
 * Example:
 * Input:  "Hello"
 *
 * H -> H + 32 -> h
 * e -> e
 * l -> l
 * l -> l
 * o -> o
 *
 * Output: "hello"
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N)
 *
 * Space Complexity:
 * O(N) - StringBuilder for the resulting string
 * ------------------------------------------------------------
 */

class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(ch >= 'A' && ch <= 'Z'){
                sb.append((char)(ch + 32));
            }
            else {
                sb.append(ch);
            }
        }

        return sb.toString();
        
    }
}