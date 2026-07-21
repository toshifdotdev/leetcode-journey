// Problem: Reverse Words in a String (#151)
// Date: 21-07-2026


// Approach (Optimal - Reverse Traversal + String Manipulation)
//
// Observation:
// Instead of reversing the entire string or using split(),
// traverse the string from right to left.
//
// 1. Trim leading and trailing spaces.
// 2. Scan from the end.
// 3. Whenever a word is found, append it to the answer.
// 4. Ignore multiple spaces between words.
//
// This avoids using extra arrays and processes each character only once.
//
// Example:
// Input : "  the   sky   is blue  "
//
// Traversal:
// blue -> is -> sky -> the
//
// Output:
// "blue is sky the"
//
// Time Complexity : O(n)
// Space Complexity: O(n)
// ------------------------------------------------------------

class Solution {
    public String reverseWords(String s) {

        // Remove leading and trailing spaces
        s = s.strip();

        int n = s.length();

        // Stores the final reversed string
        StringBuffer result = new StringBuffer();

        // Stores the index of the latest space encountered
        int trackLast = -1;

        // Marks the end index (exclusive) of the current word
        int tillWhen = n;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Space found
            if (s.charAt(i) == ' ') {

                trackLast = i;

                // Append only if the next character starts a word
                // (handles multiple consecutive spaces)
                if ((i + 1) < n && s.charAt(i + 1) != ' ') {
                    result.append(s.substring(trackLast + 1, tillWhen));
                    result.append(" ");
                }

                // Update end boundary for the next word
                tillWhen = trackLast;
            }
        }

        // Append the first word (leftmost word)
        result.append(s.substring(0, tillWhen));

        return result.toString();


        // ----------------------------------------------------
        // Alternative Approach (Cleaner Reverse Traversal)
        // ----------------------------------------------------
        /*
        StringBuilder result = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) break;

            // End index of current word
            int end = i;

            // Move to beginning of current word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Extract word
            String word = s.substring(i + 1, end + 1);

            // Add space between words
            if (result.length() > 0) {
                result.append(" ");
            }

            result.append(word);
        }

        return result.toString();
        */
    }
}