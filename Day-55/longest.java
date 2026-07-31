// Problem: Longest Common Prefix (#14)
// Date: 31-07-2026

// ------------------------------------------------------------
// Approach (Optimal - Lexicographical Sorting)
// ------------------------------------------------------------

// Time Complexity:
// O(n log n * m)
//
// n = number of strings
// m = average string length
//
// Space Complexity:
// O(1)
// (Ignoring the sorting algorithm's internal space)
//
// ------------------------------------------------------------

class Solution {

    public String longestCommonPrefix(String[] strs) {

        StringBuilder res = new StringBuilder();

        // Sort strings lexicographically
        Arrays.sort(strs);

        String s1 = strs[0];
        String s2 = strs[strs.length - 1];

        int len = Math.min(s1.length(), s2.length());

        for (int i = 0; i < len; i++) {

            if (s1.charAt(i) != s2.charAt(i)) {
                return res.toString();
            }

            res.append(s1.charAt(i));
        }

        return res.toString();
    }
}