// Problem: Longest Consecutive Sequence (#128)
// Date: 30-06-2026

// Approach 1 (Brute Force):
// Sort the array and count the length of consecutive elements.
//
// Time Complexity: O(n log n)
// Space Complexity: O(1) or O(n) depending on sorting implementation.


// Approach 2 (Optimal - Implemented):
// HashSet
//
// Idea:
// 1. Store every element in a HashSet.
// 2. Only start counting from numbers that do NOT have a predecessor.
//    (i.e. num - 1 is absent)
// 3. Continue checking num+1, num+2...
// 4. Update the maximum sequence length.
//
// Example:
// nums = [100,4,200,1,3,2]
//
// HashSet:
// {100,4,200,1,3,2}
//
// Sequence starts only from:
// 100
// 200
// 1   (because 0 doesn't exist)
//
// Counting from 1:
//
// 1
// 2
// 3
// 4
//
// Length = 4
//
// Time Complexity:
// Best Case: O(3n)
// Worst Case (all hash collisions): O(n²)
//
// Space Complexity: O(n)

class Solution {

    public int longestConsecutive(int[] nums) {

        int n = nums.length;

        if(n == 0)
            return 0;

        int longest = 0;

        HashSet<Integer> hs = new HashSet<>();

        // Store all unique elements
        for(int num : nums) {
            hs.add(num);
        }

        // Start counting only from the beginning
        // of a consecutive sequence.
        for(int num : hs) {

            if(!hs.contains(num - 1)) {

                int current = num;
                int count = 0;

                // Count the complete consecutive sequence
                while(hs.contains(current)) {
                    count++;
                    current++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}