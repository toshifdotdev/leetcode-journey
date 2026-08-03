/**
 * Problem: Valid Anagram (#242)
 * Date: 03-08-2026
 *
 * ------------------------------------------------------------
 * Approach (Optimal - Frequency Array)
 * ------------------------------------------------------------

 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 * (Only a fixed-size array of 26 characters is used.)
 *
 * ------------------------------------------------------------
 *
 * Alternative Approach (Brute Force):

 *
 * Time Complexity : O(n log n)
 * Space Complexity: O(n)
 *
 * ------------------------------------------------------------
 */

import java.util.*;

class Solution {

    public boolean isAnagram(String s, String t) {

        // Strings of different lengths can never be anagrams
        if (s.length() != t.length()) return false;

        // Convert both strings to uppercase so that
        // 'a' and 'A' map to the same index
        s = s.toUpperCase();
        t = t.toUpperCase();

        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'A']++;
        }

        // Remove frequencies using second string
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - 'A']--;
        }

        // If any frequency is not zero,
        // the strings are not anagrams
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) return false;
        }

        return true;


        // ---------------- Brute Force ----------------
        /*
        if (s.length() != t.length()) return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        String s1 = new String(arr1);
        String t1 = new String(arr2);

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != t1.charAt(i))
                return false;
        }

        return true;
        */
    }
}