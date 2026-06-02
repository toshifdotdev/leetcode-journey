// Problem: Plus One (#66)
// Date: 28-04-2026

// Note: In Java by default, elements in array are 0

// Approach:
// Traverse from right to left (carry simulation)
// If digit < 9 → increment and return
// If digit == 9 → make it 0 and carry forward
// If all digits are 9 → create new array with leading 1

// Time Complexity: O(n)
// Space Complexity: O(1) (O(n) only when new array is created)

class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] new_digits = new int[digits.length + 1];
        new_digits[0] = 1;

        return new_digits;
    }
}