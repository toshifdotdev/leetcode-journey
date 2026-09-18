/**
 * Problem: Remove K Digits (LeetCode #402)
 * Date: 18-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Monotonic Stack
 *
 * Observation:
 * To minimize a number, we should remove a larger digit that
 * appears before a smaller digit.
 *
 * Example:
 * Input: num = "1432219", k = 3
 
 * Remove 4 -> "132219"
 * Remove 3 -> "12219"
 * Remove 2 -> "1219"
 *
 * Output: "1219"
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(n)
 *
 * Each digit is added once and removed at most once.
 *
 * Space Complexity:
 * O(n)
 *
 * The list can contain up to n digits.
 *
 * ------------------------------------------------------------
 */

class Solution {
    
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        int n = num.length();
        List<Character> li = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            // Remove previous larger digits because the current
            // smaller digit should come earlier to minimize the number.
            while(!li.isEmpty() && k > 0 && li.get(li.size()-1)-'0' > num.charAt(i) - '0') {
                li.remove(li.size()-1);
                k--;
                
            }

            li.add(num.charAt(i));
        }

        // If k digits are still left to remove, remove them
        // from the end because the remaining digits are non-decreasing.
        while(k > 0) {
            li.remove(li.size()-1);
            k--;
        }

        if(li.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();

        for(char ch : li) {
            sb.append(ch);
        }

        // Remove leading zeroes from the resulting number.
        while(!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        if(sb.isEmpty()) return "0";
        return sb.toString();
        
    }
}