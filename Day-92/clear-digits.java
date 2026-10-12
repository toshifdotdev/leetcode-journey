```java
/**
 * Problem: Clear Digits (#3174)
 * Date: 12-10-2026
 *
 * ------------------------------------------------------------
 * Approach: StringBuilder
 *
 * Example:
 * Input: "abc3d2"
 *
 * a -> append -> "a"
 * b -> append -> "ab"
 * c -> append -> "abc"
 * 3 -> remove c -> "ab"
 * d -> append -> "abd"
 * 2 -> remove d -> "ab"
 *
 * Output: "ab"
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N) - each character is processed once
 *
 * Space Complexity:
 * O(N) - StringBuilder stores the remaining characters
 * ------------------------------------------------------------
 */

class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch - '0' >= 0 && ch - '0' <= 9) {
                if(!sb.isEmpty()) sb.deleteCharAt(sb.length() - 1);
            }
            else sb.append(ch);
        }

        return sb.toString();
        
    }
}
```