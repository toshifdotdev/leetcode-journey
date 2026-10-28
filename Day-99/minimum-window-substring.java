```java
/**
 * Problem: Minimum Window Substring (#76)
 * Date: 29-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Sliding Window + Frequency Array
 *
 * Example:
 * s = "ADOBECODEBANC"
 * t = "ABC"
 *
 * Minimum window substring = "BANC"
 *
 * Output: "BANC"
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N + M) - preprocessing t and traversing s.
 *
 * Space Complexity:
 * O(1) - fixed-size frequency array of 256 entries.
 * ------------------------------------------------------------
 */

class Solution {
    public String minWindow(String s, String t) {
        // Optimal:

        int l = 0, r = 0, n = s.length(), m = t.length();

        int[] hash = new int[256];

        //  Pre-Compute
        for(int i = 0; i < m; i++) hash[t.charAt(i)]++;

        int miniLen = Integer.MAX_VALUE;  // 10^9
        int sIdx = -1;
        int cnt = 0;

        while(r < n) {
            if(hash[s.charAt(r)] > 0) cnt++;
            hash[s.charAt(r)]--;

            while(cnt == m) {
                if((r-l+1) < miniLen) {
                    miniLen = r-l+1;
                    sIdx = l;
                }
                hash[s.charAt(l)]++;
                
                if(hash[s.charAt(l)] > 0) cnt--;
                l++;
            }
            r++;
        }
        
        return sIdx == -1 ? "" : s.substring(sIdx, sIdx+miniLen);

        // Brute-Force
        // int n = s.length(), m = t.length(), minLen = Integer.MAX_VALUE, sIndex = -1; 
        // for(int i = 0; i < n; i++) {
        //     int[] hash = new int[256];
        //     int cnt = 0;
        //     for(int j = 0; j < m; j++) hash[t.charAt(j)]++;

        //     for(int j = i; j < n; j++) {
        //         if(hash[s.charAt(j)] > 0) cnt++;
        //         hash[s.charAt(j)]--;
        //         if(cnt == m) {
        //             if((j - i + 1) < minLen) {
        //                 minLen = j - i+1;
        //                 sIndex = i;
        //             }
        //             break;
        //         }
        //     }
        // }
        // return sIndex == -1 ? "" : s.substring(sIndex, sIndex+minLen);
    }
}
```