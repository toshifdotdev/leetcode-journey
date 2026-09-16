/**
 * Problem: Longest Palindromic Substring
 * Date: 16-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Expand Around Center
 *
 * Time Complexity:
 * O(n^2)
 *
 * Space Complexity:
 * O(n)
 * (Due to substring/output storage; auxiliary space is O(1)
 * apart from the returned/current strings.)
 *
 * ------------------------------------------------------------
 */

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;
        
        String LPS = "";

        for(int i = 1; i < n; i++) {

            // Odd-length palindrome
            int left = i;
            int right = i;

            while(left >= 0 && right<n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            String pal = s.substring(left+1, right);
            if(pal.length() > LPS.length()) {
                LPS = pal;
            }


            // Even-length palindrome
            left = i-1;
            right = i;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            pal = s.substring(left+1, right);
            if(pal.length() > LPS.length()) {
                LPS = pal;
            }
        }

        return LPS;
        
    }
}