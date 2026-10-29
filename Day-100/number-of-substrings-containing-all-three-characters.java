```java
/**
 * Problem: Number of Substrings Containing All Three Characters (#1358)
 * Date: 29-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Last Seen Index
 * ------------------------------------------------------------
 *
 * Maintain an array of size 3 to store the last seen index
 * of characters 'a', 'b', and 'c'.
 *
 * Initially, all indices are set to -1 because none of the
 * characters has appeared yet.
 *
 * Traverse the string:
 *
 * 1. Update the last seen index of the current character.
 * 2. If all three characters have appeared, find the minimum
 *    among their last seen indices.
 * 3. The minimum index determines how many valid starting
 *    positions exist for substrings ending at the current index.
 * 4. Add (mini + 1) to the total count.
 *
 * Observation:
 * If the earliest last seen index among 'a', 'b', and 'c' is
 * mini, every substring starting from index 0 through mini
 * and ending at the current index contains all three characters.
 *
 * Example:
 * s = "abcabc"
 *
 * Valid substrings ending at each index:
 * index 2 -> 1
 * index 3 -> 2
 * index 4 -> 3
 * index 5 -> 4
 *
 * Total = 1 + 2 + 3 + 4 = 10
 *
 * Output: 10
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N) - each character is processed once, and finding the
 *         minimum among three indices takes constant time.
 *
 * Space Complexity:
 * O(1) - fixed-size array of three elements.
 * ------------------------------------------------------------
 */

class Solution {
    public int numberOfSubstrings(String s) {
        // Better
        int i = 0, n = s.length();
        int[] hash = {-1, -1, -1};
        int cnt = 0;

        while(i < n) {
            hash[s.charAt(i) - 'a'] = i;

            if(hash[0] >= 0 && hash[1] >= 0 && hash[2] >= 0) {
                int mini = Integer.MAX_VALUE;
                for(int elem : hash) 
                    if(mini > elem) mini = elem;
                cnt = cnt + (mini+1);
            }
            i++;
        }

        return cnt;

        // brute-force
        // int cnt =0, n = s.length();
        // for(int i = 0; i < n; i++) {
        //     int[] hash = new int[3];
        //     for(int j = i; j < n; j++) {
        //         hash[s.charAt(j)-'a'] = 1;
        //         if(hash[0]+hash[1]+hash[2] == 3) { 
        //             cnt = cnt + (n - j);
        //             break;
        //         }
        //     }
        // }
        // return cnt;
    }
}
```