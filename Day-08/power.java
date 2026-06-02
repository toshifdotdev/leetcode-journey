// Problem: Power of Two (#231)
// Date: 30-04-2026


// Approach:
// A power of 2 has only one set bit in binary
// n & (n - 1) removes that bit → should become 0

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1))==0;
  
    }
}