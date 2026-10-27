```java
/**
 * Problem: Longest Repeating Character Replacement (#424)
 * Date: 27-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Sliding Window + Frequency Array
 * ------------------------------------------------------------
 *
 * Example:
 * s = "AABABBA"
 * k = 1
 *
 * One longest valid substring is "AABA".
 * Replace 'B' with 'A' to obtain "AAAA".
 *
 * Output: 4
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N) - each character is processed once.
 *
 * Space Complexity:
 * O(1) - the frequency array always has 26 entries.
 * ------------------------------------------------------------
 */

class Solution {
    public int characterReplacement(String s, int k) {
        // Optimal

        int l = 0, r = 0, n = s.length(), maxiLen = 0, maxiFreq = 0;
        int[] hash = new int[26];

        while(r < n) {
            hash[s.charAt(r) - 'A']++;
            maxiFreq = Math.max(maxiFreq, hash[s.charAt(r) - 'A']);

            if(((r - l + 1) - maxiFreq) > k) {
                // trimming
                hash[s.charAt(l) - 'A']--;
                // maxiFreq= 0;
                l++;
            }

            maxiLen = Math.max(maxiLen, r - l + 1);
            r++;
        }
        return maxiLen;

        // Better:
        // int l = 0, r = 0, n = s.length(), maxiLen = 0, maxiFreq = 0;
        // int[] hash = new int[26];

        // while(r < n) {
        //     hash[s.charAt(r) - 'A']++;
        //     maxiFreq = Math.max(maxiFreq, hash[s.charAt(r) - 'A']);

        //     while(((r - l + 1) - maxiFreq) > k) {
        //         // trimming
        //         hash[s.charAt(l) - 'A']--;
        //         maxiFreq= 0;
        //         for(int elem : hash) maxiFreq = Math.max(maxiFreq, elem);
        //         l++;
        //     }

        //     maxiLen = Math.max(maxiLen, r - l + 1);
        //     r++;
        // }
        // return maxiLen;

        // brute-force
        // int n = s.length();
        // int maxiLen = 0;

        // for(int i = 0; i < n; i++) {
        //     int maxiFreq = 0;
        //     int[] hash = new int[26];
        //     for(int j = i ; j < n; j++) {
        //         char ch = s.charAt(j);
        //         hash[ch - 'A']++;
        //         maxiFreq = Math.max(maxiFreq, hash[ch - 'A']);

        //         int len = j - i + 1;

        //         int toBeChange = len - maxiFreq;
        //         if(toBeChange <= k) {
        //             maxiLen = Math.max(maxiLen, len);
        //         }
        //     }
        // }
        // return maxiLen;
    }
}
```