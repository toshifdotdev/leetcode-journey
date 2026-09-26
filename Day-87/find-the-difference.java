/**
 * Problem: Find the Difference (#389)
 * Date: 26-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Bit Manipulation (XOR)
 * ------------------------------------------------------------
 *
 * XOR has two important properties:
 * 1. a ^ a = 0
 * 2. a ^ 0 = a
 *
 * Since t contains all characters of s plus one extra character,
 * XORing every character of both strings cancels out all the
 * characters that appear in both strings.
 *
 * The remaining character is the extra character.
 *
 * Example:
 * s = "abcd"
 * t = "abcde"
 *
 * XOR all characters:
 * a ^ b ^ c ^ d ^ a ^ b ^ c ^ d ^ e
 *
 * All matching characters cancel out, leaving:
 * e
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N)
 *
 * Space Complexity:
 * O(1)
 * ------------------------------------------------------------
 */

class Solution {
    public char findTheDifference(String s, String t) {
        // Optimal
        char res = 0;

        for(char ch : s.toCharArray()) {
            res ^= ch;
        }

        for(char ch : t.toCharArray()) {
            res ^= ch;
        }

        return res;

        // Better
        // int[] hash = new int[26];
        // int n = s.length();
        // int charPos = 0;
        // for(int i = 0; i < n; i++) { 

        //     hash[s.charAt(i) - 'a']++; 
        // }
        

        // // cancel out a x a
        // for(int i = 0; i < n+1; i++) { 

        //     hash[t.charAt(i) - 'a']--; 
        // }

        // for(int i = 0; i < 26; i++) {
        //     if(hash[i] == -1) { 
        //         charPos = i;
        //     }
        // }

        // return (char)(charPos + 'a');
        
    }
}