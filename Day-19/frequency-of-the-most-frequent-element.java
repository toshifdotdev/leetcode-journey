// Problem: Frequency of the Most Frequent Element (#1838)
// Date: 19-06-2026

// Approach:
// 1. Sort the array.
// 2. Use a sliding window [l...r].
// 3. Treat nums[r] (largest element in the window) as the target value.
// 4. Calculate operations needed to make all elements equal to nums[r]:
//
//      operations = nums[r] * windowSize - currentWindowSum
//
// 5. If operations > k, shrink the window from the left.
//
// Why long?
// nums[r] * windowSize and running sum can exceed int range.
//
// Example:
// nums = [1,2,4], k = 5
//
// To make all numbers equal to 4:
//
// 4×3 = 12
// Current sum = 1+2+4 = 7
//
// Operations needed = 12 - 7 = 5
//
// Frequency = 3

// Time Complexity:
// Sorting: O(n log n)              

// ----------------------------------------------
// Biggest Lesson From #1838
// Nested loops are NOT always O(n²).

// Because:
// left pointer moves at most n times
// right pointer moves at most n times

// Total work = 2n = O(n)

// ----------------------------------------------


// Sliding Window: O(n)
// Overall: O(n log n)

// Space Complexity: O(1)
// (Ignoring sorting space)
import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int l = 0;
        int maxFreq = 1;
        long total = 0;

        for(int r = 0; r < nums.length; r++) {

            total += nums[r];

            // Window invalid -> too many operations required
            while((long) nums[r] * (r - l + 1) > total + k) {
                total -= nums[l];
                l++;
            }

            // Current window is valid
            maxFreq = Math.max(maxFreq, r - l + 1);
        }

        return maxFreq;
    }
}