// Problem: Remove Outermost Parentheses (#1021)
// Date: 19-07-2026

// Approach (Optimal - String Traversal + Counter)

// Example:
// s = "(()())(())"
//
// Primitive 1: (()()) -> ()()
// Primitive 2: (())   -> ()
//
// Result = "()()()"
//
// ------------------------------------------------------------
//
// Time Complexity:
// O(n)
//
// Space Complexity:
// O(n)   // StringBuilder stores the resulting string
// ------------------------------------------------------------

class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder sb = new StringBuilder();

        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                cnt++;

                if (cnt > 1)
                    sb.append('(');

            } else {

                cnt--;

                if (cnt > 0)
                    sb.append(')');
            }
        }

        return sb.toString();
    }
}