/**
 * Problem: Rotate String (#796)
 * Date: 02-08-2026
 *
 *-------------------------------------------------------------
 * Approach (Optimal - String Concatenation)
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * ------------------------------------------------------------
 *
 * Alternative Approach (Brute Force):
 *
 * Generate every possible rotation and compare it
 * with the goal string.
 *
 * Time Complexity : O(n²)
 * Space Complexity: O(n)
 *
 * ------------------------------------------------------------
 */

class Solution {

    public boolean rotateString(String s, String goal) {

        // ---------------- Optimal Approach ----------------

        // Strings of different lengths cannot be rotations
        if (s.length() != goal.length()) {
            return false;
        }

        // Concatenate the string with itself
        String temp = s + s;

        // Check if goal exists as a substring
        if (temp.contains(goal))
            return true;

        return false;


        // ---------------- Brute Force Approach ----------------
        /*
        if (s.length() != goal.length()) {
            return false;
        }

        // Generate every possible rotation
        for (int i = 0; i < s.length(); i++) {

            String rotated = s.substring(i) + s.substring(0, i);

            if (rotated.equals(goal))
                return true;
        }

        return false;
        */
    }
}