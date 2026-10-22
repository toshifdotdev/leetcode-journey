```java
/**
 * Problem: Longest Substring Without Repeating Characters (#3)
 * Date: 22-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Sliding Window + HashMap
 * ------------------------------------------------------------
 *
 * Maintain a sliding window using two pointers:
 * - l: Left boundary of the current window.
 * - r: Right boundary of the current window.
 *
 * Store each character's most recent index in a HashMap.
 *
 * For every character:
 * 1. Check whether it already exists in the map and whether
 *    its previous occurrence lies inside the current window.
 * 2. If so, move l to one position after its previous index.
 * 3. Update maxiLen with the current window length.
 * 4. Store the character's latest index and move r forward.
 *
 * Observation:
 * The condition hm.get(ch) >= l ensures that the left pointer
 * only moves forward when the repeated character is inside the
 * current window.
 *
 * Example:
 * s = "abcabcbb"
 *
 * The longest substring without repeating characters is "abc".
 *
 * Output: 3
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N) - each character is processed once.
 * Expected O(N) with HashMap operations taking O(1) on average.
 *
 * Space Complexity:
 * O(min(N, character set size)) for the HashMap.
 * ------------------------------------------------------------
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Optimal
        // Sliding window
        int l = 0, r = 0, maxiLen = 0;
        int n = s.length();

        HashMap<Character, Integer> hm = new HashMap<>(256);  // can take O(nlogn) or O(1 or n) depending on map so taking hashMap of 256 characters since it covers all cahracters 

        while(r < n) {
            char ch = s.charAt(r);
            if(hm.containsKey(ch) && hm.get(ch) >= l) {
                l = hm.get(ch) + 1;
            }
            maxiLen = Math.max(maxiLen, r - l + 1);
            hm.put(ch, r);
            r++;
        }

        return maxiLen;

        // Brute 

        // int maxiLen = 0;
        // int n = s.length();

        // for(int i = 0; i < n; i++) {
        //     Set<Character> set = new HashSet<>();
        //     for(int j = i; j < n; j++) {
        //         if(set.contains(s.charAt(j))) {
        //             break;
        //         }
        //         set.add(s.charAt(j));
        //     }
        //     maxiLen = Math.max(maxiLen, set.size());
        // }

        // return maxiLen;
    }
}
```