// Problem: Two Sum (#1)
// Date: 28-06-2026

// Approach 1 (Brute Force):
// Check every possible pair.
//
// Time Complexity: O(n²)
// Space Complexity: O(1)


// Approach 2 (Optimal - Implemented):
// HashMap
//
// Store each number along with its index.
// For every element, calculate:
//
//      more = target - currentNumber
//
// If the more already exists in the HashMap,
// we've found the required pair.
//
// Otherwise, store the current number and continue.
//
// Example:
// nums = [2,7,11,15]
// target = 9
//
// i = 0
// more = 7
// HashMap = {}
// Store {2 -> 0}
//
// i = 1
// more = 2
// HashMap contains 2 ✔
//
// Answer = [1,0]

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            // Number required to reach target
            int more = target - nums[i];

            // Pair found
            if(map.containsKey(more)) {
                return new int[]{i, map.get(more)};
            }

            // Store current number and its index
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}