/**
 * Problem: Valid Parentheses (#20)
 * Date: 10-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Stack
 * ------------------------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * ------------------------------------------------------------
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }
            else {

                if(st.isEmpty()) return false;

                else {
                    char br = st.pop();

                    if((br == '(' && s.charAt(i) == ')') ||
                       (br == '[' && s.charAt(i) == ']') ||
                       (br == '{' && s.charAt(i) == '}')) {

                        continue;

                    } else {
                        return false;
                    }
                }
            }
        }

        // All opening brackets must have been matched
        return st.isEmpty();
    }
}