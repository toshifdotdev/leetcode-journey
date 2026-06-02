// Problem: Maximum Nesting Depth of Parentheses (#1614)
// Date: 22-04-2026

// Approach:
// Increase depth for '('
// Decrease for ')'
// Track maximum depth

class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int max = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                count++;
                max = Math.max(max, count);
            } else if(c == ')'){
                count--;
            }
        }
        
        return max;
    }
}